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

package org.xiangxin.atrans.data;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;

import java.io.File;
import java.io.IOException;
import java.util.function.BiConsumer;

/**
 * @author yuxiangxin
 * @since 2021-05-24
 */
public class ClassName {
    private static final String STRING_ANDROID = "android";
    private static final String STRING_HARMONY = "harmony";

    // 匹配替换 全部替换 匹配到全部替换
    public static final String MODE_CONTAINS = "contains_match";
    public static final String MODE_WORD = "word_all";
    public static final String MODE_CONTAINS_ALL = "contains_all";

    public static void main (String[] args) throws IOException {
        Document document = new DocumentFactory().createDocument();
        DOMElement rootElement = new DOMElement("rule");
        document.setRootElement(rootElement);

        // elementName UI控件类名
        UIWidgetMap.Map.forEach((key, attribute) -> {
            if (Utils.isEmpty(attribute.getText())) {
                return;
            }
            if (Utils.isEmpty(key) || key.equals(attribute.getText())) {
                return;
            }
            Element reply = rootElement.addElement("reply");
            reply.setText(attribute.getText());
            reply.addAttribute("name", "elementName");
            reply.addAttribute("src", key);
            reply.addAttribute("mode", attribute.getMode());
        });
        //  <reply name="attributeName" src="background">backgroundElement</reply>
        // attributeName
        AttributeNameMap.Map.forEach(new BiConsumer<String, Attribute>() {
            @Override
            public void accept (String key, Attribute attribute) {
                if (Utils.isEmpty(attribute.getText())) {
                    return;
                }
                if (Utils.isEmpty(key) || key.equals(attribute.getText())) {
                    return;
                }
                Element reply = rootElement.addElement("reply");
                reply.setText(attribute.getText());
                reply.addAttribute("name", "attributeName");
                reply.addAttribute("src", key);
                reply.addAttribute("mode", attribute.getMode());
            }
        });

        //  <reply name="attributeValue" src="@+id/">$+id:</reply>
        AttributeValueMap.Map.forEach(new BiConsumer<String, Attribute>() {
            @Override
            public void accept (String key, Attribute attribute) {
                if (Utils.isEmpty(attribute.getText())) {
                    return;
                }
                if (Utils.isEmpty(key) || key.equals(attribute.getText())) {
                    return;
                }
                Element reply = rootElement.addElement("reply");
                reply.setText(attribute.getText());
                reply.addAttribute("name", "attributeValue");
                reply.addAttribute("src", key);
                reply.addAttribute("mode", attribute.getMode());
            }
        });


        System.out.println("" + document.asXML());
    }


    private static void printUiWidgetPut () throws IOException {
        String property = System.getProperty(("user.dir"));
        String baseDir = "\\make\\platform\\uiwidget";
        File harmonyClassFile = new File(property + baseDir, STRING_ANDROID);
        String content = IoUtils.getFileContent(harmonyClassFile);
        String[] split = content.split("\n");
        for (int i = 0; i < split.length; i++) {
            String line = split[i];
            if (!Utils.isTrimEmpty(line) && !Utils.isEmpty(line.replace("\r", ""))) {
                // <reply name="elementName" src="View" mode="word">Picker (ohos.agp.components)</reply>
                String trim = line.replace("\r", "").trim();


                String clzName = trim.substring(0, trim.indexOf("(") - 1);
                if (clzName.contains(" ")) {
                    continue;
                }
                if (clzName.startsWith("Abs")) {
                    continue;
                }
                String mode = MODE_WORD;
                if (trim.contains("androidx") || trim.contains("google")) {
                    mode = MODE_CONTAINS_ALL;
                }
                String format = "put(\"%s\", %s new Attribute().setMode(\"%s\")%s.setText(\"%s\"));";
                System.out.println("" + String.format(format, clzName, appendSpace(clzName.length(), 35), mode, appendSpace(mode.length(), 14), ""));
            }
        }
    }

    private static String appendSpace (int current, int off) {
        String append = "";
        while (current++ < off) {
            append += " ";
        }
        return append;
    }


}
