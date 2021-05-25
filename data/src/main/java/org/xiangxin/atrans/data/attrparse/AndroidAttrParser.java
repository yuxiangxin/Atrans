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

package org.xiangxin.atrans.data.attrparse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xiangxin.atrans.data.Attribute;
import org.xiangxin.atrans.data.AttributeNameMap;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author yuxiangxin
 * @since 2021-05-25
 */
public class AndroidAttrParser {
    private static String attrPath = "D:\\android\\sdk\\platforms\\android-30\\data\\res\\values\\attrs.xml";
    public static void parser (String path) {
        SAXReader reader = new SAXReader();
        Document document = null;
        String result = null;
        try {
            document = reader.read(path);
            Element element = document.getRootElement();
            List<Element> component = element.elements("declare-styleable");

            Map<String, Attribute> names = new LinkedHashMap<>();
            Map<String, Attribute> values = new LinkedHashMap<>();


            component.forEach(new Consumer<Element>() {
                @Override
                public void accept (Element element) {
                    List<Element> attr = element.elements("attr");
                    attr.forEach(new Consumer<Element>() {
                        @Override
                        public void accept (Element element) {
                            names.put(element.attributeValue("name"),new Attribute().setMode(AttributeNameMap.MODE_WORD));

                            element.elements("enum").forEach(new Consumer<Element>() {
                                @Override
                                public void accept (Element element) {
                                    values.put(element.attributeValue("name"),new Attribute().setMode(AttributeNameMap.MODE_WORD));
                                }
                            });
                        }
                    });

                }
            });
            System.out.println("" + names);
            System.out.println("" + values);
            HashSet<String> strings = new HashSet<>();
            values.forEach(new BiConsumer<String, Attribute>() {
                @Override
                public void accept (String key, Attribute attribute) {
                    String format = "put(\"\", new Attribute().setMode(MODE_WORD).setText(\"%s\"));";
                    boolean add = strings.add(key);
                    if (add) {
                        System.out.println(String.format(format, key));
                    }
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        parser(attrPath);
    }
}
