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

package org.xiangxin.atrans.translate.extend;

import org.dom4j.Attribute;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

/**
 * @author yuxiangxin
 * @since 2021-05-18
 */
public class AndroidXmlDocumentFactory extends DocumentFactory {
    @Override
    public Attribute createAttribute(Element owner, QName qname, String value) {
        return new EditEnableAttribute(qname, value);
    }

    @Override
    public Attribute createAttribute(Element owner, String name, String value) {
        return new EditEnableAttribute(name, value);
    }

    @Override
    public Namespace createNamespace(String prefix, String uri) {
        return new EditAbleNamespace(prefix, uri);
    }

}
