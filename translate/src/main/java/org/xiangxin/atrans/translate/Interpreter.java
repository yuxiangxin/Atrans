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
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.xiangxin.atrans.translate.extend.AndroidXmlDocumentFactory;
import org.xiangxin.atrans.utils.CloseableUtils;
import org.xiangxin.atrans.utils.LogUtils;

import java.io.File;
import java.io.IOException;

/**
 * 转换器引擎,负责读写文件,匹配对应的转换器处理
 *
 * @author yuxiangxin
 * @since 2021-05-04
 */
public class Interpreter {
    private File src;
    private Printer printer;

    public Interpreter (File src, Printer printer) {
        this.src = src;
        this.printer = printer;
    }

    public void translate (String parser) {
        translate(parser == null ? XmlTranslateFactory.Parser.AUTO : XmlTranslateFactory.Parser.valueOf(parser));
    }

    public void translate (XmlTranslateFactory.Parser parser) {
        SAXReader reader = new SAXReader();
        reader.setDocumentFactory(new AndroidXmlDocumentFactory());
        Document document = null;
        XmlTranslate translator = null;
        String result = null;
        try {
            document = reader.read(src);
            translator = XmlTranslateFactory.createTranslator(document, parser);
            if (translator == null) {
                throw new UnSupportTranslateType(document.getName());
            }
            LogUtils.v("Interpreter", "Matched XmlTranslate: " + translator.getClass().getSimpleName() + ", Printer: " + printer.getClass().getSimpleName() + "\n");
            result = translator.translate(document);
            printer.println(result);
        } catch (DocumentException | IOException e) {
            LogUtils.e(e);
            throw new UnSupportTranslateType(e.getMessage());
        } finally {
            CloseableUtils.ioClose(printer);
        }
    }

    public static void main (String[] args) {
        String base = "\\app\\src\\main\\res";
        String layoutName = base + "\\layout";
        String valuesName = base + "\\values";
        File stringXml = new File(valuesName, "strings.xml"); // dimens strings
        File layoutPath = new File(layoutName, "activity.xml"); // activity_about activity_account_mgr
        new Interpreter(stringXml, new SystemOutPrinter()).translate(XmlTranslateFactory.Parser.AUTO);
    }
}
