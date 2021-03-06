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

/**
 * @author yuxiangxin
 * @since 2021-05-20
 */
public class ContainsMatchValue extends AbsNodeItemValue {
    public ContainsMatchValue (String src, String value) {
        super(src, value);
    }

    @Override
    public boolean isMatch(String value) {
        return value.contains(getSrc());
    }

    @Override
    public String reply(String value) {
        return value.replace(getSrc(), getValue());
    }
}
