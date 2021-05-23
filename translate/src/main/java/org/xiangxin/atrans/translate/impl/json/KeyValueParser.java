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

import com.alibaba.fastjson.JSON;

import org.dom4j.Document;
import org.dom4j.Element;
import org.xiangxin.atrans.translate.XmlTranslate;
import org.xiangxin.atrans.utils.LogUtils;

import java.util.ArrayList;

/**
 * @author yuxiangxin
 * @since 2021-05-06
 */
public class KeyValueParser implements XmlTranslate {
    public final String TAG = getClass().getSimpleName();
    private final ItemParser parser = ParserLoader.getItemParser();

    @Override
    public String translate(Document document) {
        Element rootElement = document.getRootElement();
        ArrayList<Object> arrayList = new ArrayList<>();
        rootElement.elements().forEach(element -> {
            String elementName = element.getName();
            if (parser.isSupport(elementName)) {
                arrayList.add(parser.parserElement(elementName, element));
            } else {
                LogUtils.e(TAG, "Ignore parser element with name:" + element.asXML());
            }
        });
        return JSON.toJSONString(arrayList);
    }
}
