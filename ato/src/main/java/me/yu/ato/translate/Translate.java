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

package me.yu.ato.translate;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import me.yu.ato.Main;

/**
 * @author yuxiangxin
 * @since 2021-05-04
 */
public class Translate {
    private final java.lang.String TAG = getClass().getSimpleName();
    private static final RecentlyMap<ElementParser> PARSE_MAP = new RecentlyMap<ElementParser>() {{
        put(ElementParser.ELEMENT_TYPE_STRING, new ItemKeyValueElementParser());
        put(ElementParser.ELEMENT_TYPE_BOOLEAN, new ItemKeyValueElementParser());
        put(ElementParser.ELEMENT_TYPE_COLOR, new ItemKeyValueElementParser());
        put(ElementParser.ELEMENT_TYPE_DIMEN, new DimenElementParser());
        put(ElementParser.ELEMENT_TYPE_INTEGER, new DimenElementParser());
        put(ElementParser.ELEMENT_TYPE_ARRAY, new ArrayElementParser());
    }};

    private TranslateResultHandler resultHandler;
    private File src;

    public Translate(File src, TranslateResultHandler resultHandler) {
        this.src = src;
        this.resultHandler = resultHandler;
    }

    public void start() {
        SAXReader reader = new SAXReader();
        Document document;
        try {
            document = reader.read(src);
            Element rootElement = document.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();

                String content = null;
                try {
                    content = translateElement(element);
                } catch (UnSupportTranslateType e) {
                    Main.handlerException(e);
                }
                resultHandler.append(content);
            }
        } catch (DocumentException | IOException e) {
            throw new TranslateException(e);
        } finally {
            try {
                resultHandler.done();
            } catch (IOException e) {
                // ignore
            }
        }
    }

    protected String translateElement(Element element) {
        /*return PARSE_MAP.get(element.getName())
                .map(parser -> parser.translate(element))
                .orElseThrow(() -> new UnSupportTranslateType(element));*/
        return PARSE_MAP.get(element.getName())
                .map(parser -> parser.translate(element))
                .orElse("");
    }

    //
    public static void main(java.lang.String[] args) {
        java.lang.String target = "C:\\Users\\Administrator\\Desktop\\temp\\atotest\\test.xml";
        Translate translate = new Translate(new File(target), new CatTranslateResultHandler());
        translate.start();
    }

}
