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
 * @author yuxiangxin
 * @since 2021-05-05
 */
public interface ElementParser {
    String ELEMENT_TYPE_STRING = "string";
    String ELEMENT_TYPE_ARRAY = "array";
    String ELEMENT_TYPE_BOOLEAN = "bool";
    String ELEMENT_TYPE_COLOR = "color";
    String ELEMENT_TYPE_DIMEN = "dimen";
    String ELEMENT_TYPE_INTEGER = "integer";

    String ATTRIBUTE_NAME = "name";

    String translate(Element element);
}
