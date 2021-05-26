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

package org.xiangxin.atrans.translate.impl.reply;

import org.dom4j.Element;

/**
 * Element对象替换
 *
 * @author yuxiangxin
 * @since 2021-05-23
 */
public interface XmlReply {
    String ELEMENT_NAME = "elementName";
    String ELEMENT_VALUE = "elementValue";
    String ATTRIBUTE_NAME = "attributeName";
    String ATTRIBUTE_VALUE = "attributeValue";
    String NAMESPACE_URI = "namespaceURI";
    String NAMESPACE_PREFIX = "namespacePrefix";

    void reply (Element element);

    String replyNamespacePrefix (String namespacePrefix);

    String replyNamespaceURI (String namespaceURI);
}
