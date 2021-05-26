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

import org.xiangxin.atrans.utils.LogUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Translate command启动入口
 * 负责将atrans.bat传来的参数处理, 再由解析器解析运行
 *
 * @author yuxiangxin
 * @since 2021-04-18
 */
public class Main {
    private static final String TAG = "Main";
    public static boolean DEBUG = true;

    public static void main (String[] args) {
        String path = "C:\\SimpleWowo\\wowoandroid-androidstudio\\app\\src\\main\\res\\values [strings, color] /p22 auto";
        String params = "1 /s " + path + " /c";
        args = params.split(" ");

        try {
            CommandParse.parse(clearFilterSpace(args)).run();
        } catch (Exception e) {
            formatGuide(e);
        }
    }

    private static void formatGuide (Exception e) {
        //if (e instanceof IllegalArgumentException) {
        LogUtils.i(TAG, "命令语法不正确, 键入 trans /? 以查看帮助");
        //}
        e.printStackTrace();
    }

    private static String[] clearFilterSpace (String[] args) {
        if (args == null || args.length == 0) {
            return null;
        }
        String itemAppend = "<------>";
        StringBuilder stringBuilder = new StringBuilder();
        int argsSize = args.length;
        for (int i = 0; i < argsSize; i++) {
            String each = args[i];
            stringBuilder.append(each);
            if (i + 1 <= argsSize) {
                stringBuilder.append(itemAppend);
            }
        }
        String argsString = stringBuilder.toString();
        String regex = "\\[.+]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(stringBuilder);
        while (matcher.find()) {
            String filter = matcher.group();
            argsString = argsString.replace(filter, filter.replace(itemAppend, ""));
        }
        return argsString.split(itemAppend);
    }
}