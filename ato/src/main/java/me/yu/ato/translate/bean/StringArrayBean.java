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

package me.yu.ato.translate.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxiangxin
 * @since 2021-05-06
 */
public class StringArrayBean extends KeyValue<String, List<StringArrayBean.Value>> {

    public static class Value {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public void addValue(String addValue) {
        if (getValue() == null) {
            setValue(new ArrayList<>());
        }
        Value stringValue = new Value();
        stringValue.setValue(addValue);
        getValue().add(stringValue);
    }
}
