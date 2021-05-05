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

package me.yu.ato.utils;

/**
 * 日志打印
 *
 * @author yuxiangxin
 * @since 2021-04-23
 */
public class LogUtils {

    public static void v(String tag, String format, Object... value) {
        v(tag, String.format(format, value));
    }

    public static void v(String tag, String msg) {
        System.out.println(tag + " : " + msg);
    }

}
