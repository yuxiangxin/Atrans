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

package org.xiangxin.atrans.command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;


/**
 * atrans cmd命令转换对象
 *
 * @author yuxiangxin
 * @since 2021-04-23
 */
@Data
public class Command {
    public static final String PARSER_AUTO = "AUTO";
    public static final String PARSER_JSON = "JSON";
    public static final String PARSER_REPLY = "REPLY";

    private String chdir;
    private List<File> src = new ArrayList<>();
    private String dst;
    private boolean isCatMode;
    private boolean isHelpMode;
    private String parser;

    @Override
    public String toString () {
        return ", src=\n" + src.toString().replace(",", ",\n") + " size:" + src.size();
    }
}
