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

import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.tree.AbstractAttribute;

/**
 * @author yuxiangxin
 * @since 2021-05-18
 */
public class EditEnableAttribute extends AbstractAttribute {
    private QName qname;
    private String value;

    public EditEnableAttribute(QName qname) {
        this.qname = qname;
    }

    public EditEnableAttribute(QName qname, String value) {
        this.qname = qname;
        this.value = value;
    }

    public EditEnableAttribute(String name, String value) {
        this.qname = getDocumentFactory().createQName(name);
        this.value = value;
    }

    public EditEnableAttribute(String name, String value, Namespace namespace) {
        this.qname = getDocumentFactory().createQName(name, namespace);
        this.value = value;
    }

    @Override
    public QName getQName() {
        return qname;
    }

    @Override
    public void setNamespace(Namespace namespace) {
        this.qname = getDocumentFactory().createQName(qname.getName(), namespace);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setName(String name) {
        this.qname = getDocumentFactory().createQName(name, qname.getNamespace());
    }

    @Override
    public String asXML() {
        return super.asXML();
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
