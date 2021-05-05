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

import java.util.Collection;

/**
 * 工具类
 *
 * @author yuxiangxin
 * @since 2021-04-26
 */
public class Utils {
    public static boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }

    public static boolean isTrimEmpty(String value) {
        return value == null || "".equals(value.trim());
    }

    public static boolean isEmpty(String[] value) {
        return value == null || value.length == 0;
    }

    public static boolean isEmpty(Collection<?> collections) {
        return collections == null || collections.isEmpty();
    }

    public static <T> T getDefault(T value, T checkValue, T defValue) {
        return value == checkValue ? defValue : value;
    }
}
