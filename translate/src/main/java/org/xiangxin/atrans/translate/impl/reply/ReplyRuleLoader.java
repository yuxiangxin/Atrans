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
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xiangxin.atrans.Config;
import org.xiangxin.atrans.translate.LoadException;
import org.xiangxin.atrans.translate.impl.reply.bean.ReplyRuleBean;
import org.xiangxin.atrans.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxiangxin
 * @since 2021-05-17
 */
public class ReplyRuleLoader {
    private static final String TAG = "ReplyRuleLoader";
    private static final String STRING_REPLY = "reply";
    private static final XmlReply REPLY_IMPL = loadItemParser(Config.get().getReplyParseConfigFile());

    public static XmlReply getReplyImpl() {
        return REPLY_IMPL;
    }

    private static XmlReply loadItemParser(String path) {
        SAXReader reader = new SAXReader();
        Document document;
        try {
            document = reader.read(path);
            Element rootElement = document.getRootElement();
            List<ReplyRuleBean> replyRules = new ArrayList<>();
            rootElement.elements(STRING_REPLY).forEach(element -> {
                ReplyRuleBean rule = new OfElement<>(element, new ReplyRuleBean()).apply().get();
                if (rule.isValid()) {
                    replyRules.add(rule);
                } else {
                    LogUtils.e(TAG, "Invalid reply rule:" + rule.getElement().asXML());
                }
            });
            if (replyRules.isEmpty()) {
                throw new LoadException("无法解析配置文件,请检查配置文件内容是否正确," + path);
            }
            return new RuleReplyImpl(replyRules);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new LoadException("解析器配置错误,请检查配置文件内容是否正确," + path);
        }
    }
}
