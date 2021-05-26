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


package org.xiangxin.atrans.translate.impl.json;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xiangxin.atrans.BuildConfig;
import org.xiangxin.atrans.translate.LoadException;
import org.xiangxin.atrans.translate.impl.json.bean.KeyValue;
import org.xiangxin.atrans.translate.impl.json.bean.StringArrayBean;
import org.xiangxin.atrans.translate.impl.reply.OfElement;
import org.xiangxin.atrans.translate.impl.reply.RuleReplyImpl;
import org.xiangxin.atrans.translate.impl.reply.XmlReply;
import org.xiangxin.atrans.translate.impl.reply.bean.ReplyRuleBean;
import org.xiangxin.atrans.utils.LogUtils;
import org.xiangxin.atrans.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author yuxiangxin
 * @since 2021-05-22
 */
public class ParserLoader {
    private static final String TAG = "ParserLoader";
    private static final String STRING_PARSE = "parse";
    private static final String STRING_NAME = "name";
    private static final String STRING_JSON_KEY = "jsonKey";
    private static final String STRING_TYPE = "type";
    private static final String STRING_REPLY = "reply";
    public static final String STRING_TRUE = "true";
    public static final String STRING_FALSE = "false";

    private static final String TYPE_OBJECT = "object";
    private static final String TYPE_ARRAY = "array";

    public static final String MODE_CONTAINS_MATCH = "contains_match";
    public static final String MODE_WORD_ALL = "word_all";
    public static final String MODE_CONTAINS_ALL = "contains_all";

    private static final ItemParser ITEM_PARSER = loadItemParser(BuildConfig.KEY_VALUE_PATH);

    public static ItemParser getItemParser () {
        return ITEM_PARSER;
    }

    private static ItemParser loadItemParser (String path) {
        SAXReader reader = new SAXReader();
        Document document;
        try {
            document = reader.read(path);
            Element rootElement = document.getRootElement();

            HashMap<String, ItemParser> parserHashMap = new HashMap<>();
            rootElement.elements(STRING_PARSE).forEach(element -> {
                String itemName = element.attributeValue(STRING_NAME);
                String jsonKey = element.attributeValue(STRING_JSON_KEY, itemName);
                if (itemName == null) {
                    LogUtils.e(TAG, "Invalid parser item:" + element.asXML());
                    return;
                }

                List<Element> elements = element.elements(STRING_REPLY);
                List<ReplyRuleBean> replyRules = null;
                if (!Utils.isEmpty(elements)) {
                    replyRules = new ArrayList<>(elements.size());
                    for (Element item : elements) {
                        ReplyRuleBean rule = new OfElement<>(item, new ReplyRuleBean()).apply().get();
                        if (rule.isValid()) {
                            replyRules.add(rule);
                        } else {
                            LogUtils.e(TAG, "Invalid reply rule:" + rule.getElement());
                        }
                    }
                }
                ItemParser itemParser;
                RuleReplyImpl ruleReply = replyRules == null ? null : new RuleReplyImpl(replyRules);
                String type = element.attributeValue(STRING_TYPE, TYPE_OBJECT);
                if (TYPE_OBJECT.equals(type)) {
                    itemParser = new KeyValueParserImpl(jsonKey, ruleReply);
                } else if (TYPE_ARRAY.equals(type)) {
                    itemParser = new ArrayParserImpl(jsonKey, ruleReply);
                } else {
                    LogUtils.e(TAG, "Invalid parse type:" + element.asXML());
                    return;
                }
                parserHashMap.put(itemName, itemParser);
            });
            if (parserHashMap.isEmpty()) {
                throw new LoadException("解析器配置错误,请检查配置文件内容是否正确," + path);
            }
            return new ItemParserImpl(parserHashMap);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new LoadException("解析器加载错误,请检查配置文件是否正确." + e.getMessage());
        }
    }

    private static class ItemParserImpl implements ItemParser {
        private final HashMap<String, ItemParser> parserHashMap;

        public ItemParserImpl (HashMap<String, ItemParser> parserHashMap) {
            this.parserHashMap = parserHashMap;
        }

        @Override
        public boolean isSupport (String elementName) {
            return parserHashMap.containsKey(elementName);
        }

        @Override
        public Object parserElement (String elementName, Element element) {
            return parserHashMap.get(elementName).parserElement(elementName, element);
        }

        @Override
        public String getName (String itemName) {
            if (parserHashMap.containsKey(itemName)) {
                return parserHashMap.get(itemName).getName(itemName);
            }
            return "objects";
        }
    }

    private static class KeyValueParserImpl implements ItemParser {
        private final String jsonKey;
        private final XmlReply xmlReply;

        public KeyValueParserImpl (String parserName, XmlReply xmlReply) {
            this.xmlReply = xmlReply;
            this.jsonKey = parserName;
        }

        @Override
        public boolean isSupport (String elementName) {
            return true;
        }

        @Override
        public Object parserElement (String elementName, Element element) {
            if (xmlReply != null) {
                xmlReply.reply(element);
            }
            String key = element.attributeValue(STRING_NAME, "UN_KNOW");
            String value = element.getText();
            return new KeyValue<>(key, value);
        }

        @Override
        public String getName (String rootElementName) {
            return jsonKey;
        }
    }

    private static class ArrayParserImpl implements ItemParser {
        private final String jsonKey;
        private final XmlReply xmlReply;

        public ArrayParserImpl (String parserName, XmlReply xmlReply) {
            this.xmlReply = xmlReply;
            this.jsonKey = parserName;
        }

        @Override
        public boolean isSupport (String elementName) {
            return false;
        }

        @Override
        public Object parserElement (String elementName, Element element) {
            if (xmlReply != null) {
                xmlReply.reply(element);
            }
            StringArrayBean array = new StringArrayBean();
            String name = element.attributeValue(STRING_NAME, "UN_KNOW");
            array.setName(name);
            Iterator<Element> iterator = element.elementIterator();
            while (iterator.hasNext()) {
                Element stuChild = iterator.next();
                array.addValue(stuChild.getText());
            }
            return array;
        }

        @Override
        public String getName (String rootElementName) {
            return jsonKey;
        }
    }
}
