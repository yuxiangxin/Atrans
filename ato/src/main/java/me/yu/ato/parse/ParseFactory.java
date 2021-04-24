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

package me.yu.ato.parse;

import me.yu.ato.utils.LogUtils;

/**
 * 输入命令解析
 *
 * @author yuxiangxin
 * @since 2021-04-23
 */
public class ParseFactory {
    private static final String TAG = "ParseFactory";

    private static final Command UN_KNOW = new UnKnow();
    private static final Command HELP = new Help();


    private static final String COMMON_HELP = "^/(?i)([h?]|help)";


    public static Command parse(String[] input) {
        // JAVA - jar.\ato_V1.0.jar %cd% %1 %2 %3 %4 %5 %6 %7 %8 %9
        if (input == null || input.length <= 1) {
            return UN_KNOW;
        }
        String chdir = input[0];
        //if(input.length==2)

        return UN_KNOW;
    }

    public static void main(String[] args) {
        // (?i) //忽略大小写

        String[] array = {"/h","/H", "/?", "/HELP", "/he", "/h?", "/?h", "/help", "help", "?", "//help", "//?", "\\?"};

        String regex = "^/(?i)([h?]|help)";
        for (String item : array) {
            LogUtils.v(TAG, item + "  matches:\t" + item.matches(COMMON_HELP));
        }
    }
}
