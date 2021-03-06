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

package org.xiangxin.atrans.translate.impl.reply.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yuxiangxin
 * @since 2021-05-23
 */
public class IgnoreCaseContainsMatchValue extends AbsNodeItemValue {
    private String upperSrc;

    public IgnoreCaseContainsMatchValue (String src, String value) {
        super(src, value);
        upperSrc = src.toUpperCase();
    }

    @Override
    public boolean isMatch(String value) {
        return value.toUpperCase().contains(upperSrc);
    }

    @Override
    public String reply(String value) {
        String regex = "(?i)(" + makeQueryStringAllRegExp(getSrc()) + ")";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(value);
        String newValue = value;
        while (matcher.find()) {
            String group = matcher.group();
            newValue = value.replace(group, getValue());
        }
        return newValue;
    }

    private String makeQueryStringAllRegExp(String str) {
        if (str == null) {
            return str;
        }
        return str.replace("\\", "\\\\").replace("*", "\\*")
                .replace("+", "\\+").replace("|", "\\|")
                .replace("{", "\\{").replace("}", "\\}")
                .replace("(", "\\(").replace(")", "\\)")
                .replace("^", "\\^").replace("$", "\\$")
                .replace("[", "\\[").replace("]", "\\]")
                .replace("?", "\\?").replace(",", "\\,")
                .replace(".", "\\.").replace("&", "\\&");
    }
}
