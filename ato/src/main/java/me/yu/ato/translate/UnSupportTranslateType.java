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

package me.yu.ato.translate;

import org.dom4j.Element;

/**
 * 不支持解析异常
 *
 * @author yuxiangxin
 * @since 2021-05-05
 */
public class UnSupportTranslateType extends RuntimeException {
    public UnSupportTranslateType() {
    }

    public UnSupportTranslateType(String message) {
        super(message);
    }

    public UnSupportTranslateType(Element element) {
        this("不支持解析:" + element.getName());
    }
}
