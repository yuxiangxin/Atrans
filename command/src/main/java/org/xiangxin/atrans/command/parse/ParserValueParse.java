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
import org.xiangxin.atrans.command.InputErrorException;
import org.xiangxin.atrans.utils.LogUtils;
import org.xiangxin.atrans.utils.NextArray;
import org.xiangxin.atrans.utils.Utils;

import java.util.Locale;

/**
 * @author yuxiangxin
 * @since 2021-05-26
 */
public class ParserValueParse implements ValueParse {
    @Override
    public void parse (NextArray values, Command result) {
        if (!values.hasNext() || Utils.isEmpty(values.next().get())) {
            LogUtils.e("ParserValueParse", "指定解析器输入无效, 使用自识别");
            return;
        }
        String lowerValue = values.get().trim().toUpperCase(Locale.ROOT);
        if (Utils.isIn(lowerValue, Command.PARSER_AUTO, Command.PARSER_JSON, Command.PARSER_REPLY)) {
            result.setParser(lowerValue);
        } else {
            throw new InputErrorException(values.get() + ", 指定解析器只能为 json/reply/auto");
        }
    }
}
