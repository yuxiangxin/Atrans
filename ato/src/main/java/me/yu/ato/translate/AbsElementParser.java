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

import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * @author yuxiangxin
 * @since 2021-05-06
 */
public abstract class AbsElementParser implements ElementParser {
    @Override
    public String translate(Element element) {
        Attribute nameAttr = element.attribute(ATTRIBUTE_NAME);
        if (nameAttr != null) {
            return translate(nameAttr.getText(), element);
        }
        throw new TranslateException("Can match attribute name!");
    }

    public abstract String translate(String name, Element element);
}
