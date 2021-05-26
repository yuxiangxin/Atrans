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

package org.xiangxin.atrans.translate;

import org.dom4j.Document;
import org.dom4j.Element;
import org.xiangxin.atrans.translate.impl.json.KeyValueParser;
import org.xiangxin.atrans.translate.impl.reply.ReplyTranslator;

/**
 * 解析器创建
 *
 * @author yuxiangxin
 * @since 2021-05-23
 */
public class XmlTranslateFactory {
    private static final String STRING_RESOURCES = "resources";

    public static XmlTranslate createTranslator (Document document) {
        return createTranslator(document, Parser.AUTO);
    }

    public static XmlTranslate createTranslator (Document document, Parser useParser) {
        Element rootElement = document.getRootElement();
        if (rootElement == null) {
            throw new IllegalArgumentException();
        }
        if (Parser.AUTO.equals(useParser)) {
            if (STRING_RESOURCES.equals(rootElement.getName())) {
                return new KeyValueParser();
            } else {
                return new ReplyTranslator();
            }
        } else {
            return useParser.parser;
        }
    }

    public enum Parser {
        AUTO(null),
        JSON(new KeyValueParser()),
        REPLY(new ReplyTranslator());

        private XmlTranslate parser;

        Parser (XmlTranslate parser) {
            this.parser = parser;
        }
    }
}
