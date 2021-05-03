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

package me.yu.ato.commandparse;


import java.util.HashMap;
import java.util.Map;

import me.yu.ato.NextArray;
import me.yu.ato.command.InputTranslate;

/**
 * @author yuxiangxin
 * @since 2021-05-03
 */
public class CommandParse {
    private static final String TAG = "CommandParse";

    public static final String COMMAND_HELP_REGEX = "^/(?i)([h?]|help)";
    public static final String COMMAND_CAT_REGEX = "^/(?i)(c|cat)";
    public static final String COMMAND_DST_REGEX = "^/(?i)(d|dst)";
    public static final String COMMAND_SRC_REGEX = "^/(?i)(s|src)";

    private static final Map<String, ValueParse> PARSE_MAP = new HashMap<String, ValueParse>() {
        {
            put(COMMAND_HELP_REGEX, new HelpValueParse());
            put(COMMAND_CAT_REGEX, new CatValueParse());
            put(COMMAND_DST_REGEX, new DstValueParse());
            put(COMMAND_SRC_REGEX, new SrcValueParse());
        }
    };


    public static InputTranslate parse(String[] args) {
        final InputTranslate command = new InputTranslate();
        String chdir = args[0];
        command.setChdir(chdir);
        final NextArray nextArray = new NextArray(args);

        while (nextArray.hasNext()) {
            final String current = nextArray.next().get();
            boolean parsed = false;
            for (Map.Entry<String, ValueParse> entry : PARSE_MAP.entrySet()) {
                if (current.matches(entry.getKey())) {
                    parsed = true;
                    entry.getValue().parse(nextArray, command);
                    break;
                }
            }
            if (!parsed) {
                if (current.startsWith("/")) {
                    throw new CannotParseException("无对应解析器, 请检查输入是否正确 ", current);
                } else {
                    throw new InputErrorException("未知内容, 请检查输入 ", current);
                }
            }
        }
        return command;
    }

}
