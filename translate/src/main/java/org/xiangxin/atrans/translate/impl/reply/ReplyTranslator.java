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

import org.dom4j.Document;
import org.dom4j.Element;
import org.xiangxin.atrans.translate.XmlTranslate;

/**
 * xml转换replyImpl
 *
 * @author yuxiangxin
 * @since 2021-05-22
 */
public class ReplyTranslator implements XmlTranslate {
    private static final String TAG = "ReplyTranslator";
    private static final XmlReply REPLY_IMPL = ReplyRuleLoader.getReplyImpl();

    @Override
    public String translate (Document document) {
        Element rootElement = document.getRootElement();
        replyElement(rootElement);
        return document.asXML();
    }

    public void replyElement (Element element) {
        REPLY_IMPL.reply(element);
        element.elements().forEach(this::replyElement);
    }
}
