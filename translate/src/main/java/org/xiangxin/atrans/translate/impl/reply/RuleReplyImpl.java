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
import org.xiangxin.atrans.translate.impl.reply.bean.ReplyRuleBean;
import org.xiangxin.atrans.utils.Utils;

import java.util.List;

/**
 * reply解析器加载
 *
 * @author yuxiangxin
 * @since 2021-05-23
 */
public class RuleReplyImpl implements XmlReply {
    private final List<ReplyRuleBean> attrReplyRule;

    public RuleReplyImpl (List<ReplyRuleBean> attrReplyRule) {
        this.attrReplyRule = attrReplyRule;
    }

    @Override
    public void reply (Element element) {
        if (attrReplyRule != null) {
            attrReplyRule.forEach(replyRuleBean -> {
                String name = replyRuleBean.getName();
                switch (name) {
                    case ELEMENT_NAME:
                        element.setName(replyRuleBean.reply(element.getName()));
                        break;
                    case ELEMENT_VALUE:
                        element.setText(replyRuleBean.reply(element.getText()));
                        break;
                    case ATTRIBUTE_NAME:
                        element.attributes().forEach(attribute ->
                                attribute.setName(replyRuleBean.reply(attribute.getName())));
                        break;
                    case ATTRIBUTE_VALUE:
                        element.attributes().forEach(attribute ->
                                attribute.setValue(replyRuleBean.reply(attribute.getValue())));
                        break;
                    default:
                        // ignore
                        break;
                }
            });
        }
    }

    @Override
    public String replyNamespacePrefix (String namespacePrefix) {
        if (namespacePrefix == null) {
            return null;
        }
        String[] value = {namespacePrefix};
        if (!Utils.isEmpty(attrReplyRule)) {
            attrReplyRule.stream()
                    .filter(replyRuleBean -> XmlReply.NAMESPACE_PREFIX.equals(replyRuleBean.getName()))
                    .forEach(replyRuleBean -> value[0] = replyRuleBean.reply(value[0]));
        }
        return value[0];
    }

    @Override
    public String replyNamespaceURI (String namespaceURI) {
        if (namespaceURI == null) {
            return null;
        }
        String[] value = {namespaceURI};
        if (!Utils.isEmpty(attrReplyRule)) {
            attrReplyRule.stream()
                    .filter(replyRuleBean -> XmlReply.NAMESPACE_URI.equals(replyRuleBean.getName()))
                    .forEach(replyRuleBean -> value[0] = replyRuleBean.reply(value[0]));
        }
        return value[0];
    }
}
