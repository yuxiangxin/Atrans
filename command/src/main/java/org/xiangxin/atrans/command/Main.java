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

/**
 * ATO转换入口
 *
 * @author yuxiangxin
 * @since 2021-04-18
 */
public class Main {
    private static final String TAG = "Main";
    public static boolean DEBUG = true;

    public static void main (String[] args) {
        //String path = "C:\\SimpleWowo\\wowoandroid-androidstudio\\app\\src\\main\\res\\values\\strings.xml";
        String path = "C:\\SimpleWowo\\wowoandroid-androidstudio\\app\\src\\main\\res\\layout\\activity_my_invitation.xml";
        String params = "1 /s " + path + " /c";
        args = params.split(" ");
        try {
            CommandParse.parse(args).run();
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
}