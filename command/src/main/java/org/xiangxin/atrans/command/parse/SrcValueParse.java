/*
 * Copyright 2021 yuxiangxin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xiangxin.atrans.command.parse;

import org.xiangxin.atrans.command.Command;
import org.xiangxin.atrans.command.CommandParseException;
import org.xiangxin.atrans.command.InputErrorException;
import org.xiangxin.atrans.command.parse.filter.ContainsNameFilter;
import org.xiangxin.atrans.command.parse.filter.EqualsFilter;
import org.xiangxin.atrans.command.parse.filter.ExtFilter;
import org.xiangxin.atrans.utils.IoUtils;
import org.xiangxin.atrans.utils.NextArray;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Src解析
 *
 * @author yuxiangxin
 * @since 2021-05-03
 */
public class SrcValueParse implements ValueParse {
    private static final String EXT_ARRAY_REGEX = "^\\[.+]$";

    @Override
    public void parse (NextArray values, Command result) {
        List<File> srcList = new ArrayList<>();
        if (!values.hasNext()) {
            throw new InputErrorException("此处命令后需接文件路径或目录", values.get());
        }
        String path = values.next().get();
        File srcFile = new File(path);
        if (!srcFile.exists()) {
            throw new InputErrorException("目标文件不存在, 请确认输入是否正确", path);
        }
        // 目标文件或目录
        if (srcFile.isDirectory()) {
            final ArrayList<FileFilter> filters = new ArrayList<>();
            if (values.hasNext()) {
                String nextValue = values.next().get();
                if (nextValue.matches(EXT_ARRAY_REGEX)) {
                    String input = nextValue.substring(1, nextValue.length() - 1);
                    String[] rules = input.split(",");
                    filters.addAll(toFilter(rules));
                } else if (!nextValue.startsWith("/")) {
                    throw new InputErrorException("此处输入不正确", nextValue);
                } else {
                    values.move(-1);
                }
            }
            IoUtils.filterFile(srcFile, pathname -> {
                if (!pathname.exists() || !pathname.canRead() || pathname.isHidden()) {
                    return false;
                }
                if (filters.isEmpty()) {
                    return true;
                }
                for (FileFilter each : filters) {
                    if (each.accept(pathname)) {
                        return true;
                    }
                }
                return false;
            }, srcList);
            // 过滤
        } else {
            srcList = Collections.singletonList(srcFile);
        }
        result.setSrc(srcList);
    }


    private ArrayList<FileFilter> toFilter (String[] rules) {
        ArrayList<FileFilter> filters = new ArrayList<>(rules.length);
        for (String rule : rules) {
            if (rule.startsWith("*.")) {
                filters.add(new ExtFilter(rule));
            } else if (!rule.contains(".")) {
                filters.add(new ContainsNameFilter(rule));
            } else if (rule.matches(".+\\..+")) {
                filters.add(new EqualsFilter(rule));
            } else {
                throw new CommandParseException("规则暂不支持!", rule);
            }
        }
        return filters;
    }


}
