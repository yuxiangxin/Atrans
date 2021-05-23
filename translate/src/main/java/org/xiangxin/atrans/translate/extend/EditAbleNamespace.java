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

import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.dom.DOMNamespace;
import org.w3c.dom.DOMException;
import org.xiangxin.atrans.translate.impl.reply.ReplyRuleLoader;

import java.lang.reflect.Field;

/**
 * 可编辑Namespace
 *
 * @author yuxiangxin
 * @since 2021-05-21
 */
public class EditAbleNamespace extends DOMNamespace {
    public EditAbleNamespace(String prefix, String uri) {
        super(ReplyRuleLoader.getReplyImpl().replyNamespacePrefix(prefix),
                ReplyRuleLoader.getReplyImpl().replyNamespaceURI(uri));
    }

    public EditAbleNamespace(Element parent, String prefix, String uri) {
        super(parent, prefix, uri);
    }

    @Override
    public void setPrefix(String prefix) throws DOMException {
        try {
            Field prefixField = Namespace.class.getDeclaredField("prefix");
            prefixField.setAccessible(true);
            prefixField.set(this, prefix);
        } catch (ReflectiveOperationException e) {
            // ignore
        }
    }

    public void setURI(String uri) {
        try {
            Field uriField = Namespace.class.getDeclaredField("uri");
            uriField.setAccessible(true);
            uriField.set(this, uri);
        } catch (ReflectiveOperationException e) {
            // ignore
        }
    }

}
