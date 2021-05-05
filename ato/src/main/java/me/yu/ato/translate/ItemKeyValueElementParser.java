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

import com.alibaba.fastjson.JSON;

import org.dom4j.Element;

import me.yu.ato.translate.bean.KeyValue;
import me.yu.ato.utils.Utils;

/**
 * @author yuxiangxin
 * @since 2021-05-06
 */
public class ItemKeyValueElementParser extends AbsElementParser {
    @Override
    public String translate(String key, Element element) {
        String value = element.getText();
        if (Utils.isEmpty(key) || Utils.isEmpty(value)) {
            throw new TranslateException("解析失败:" + key);
        }
        KeyValue<String, String> keyValue = new KeyValue<>();
        keyValue.setName(modifyKey(key));
        keyValue.setValue(modifyValue(key));
        return JSON.toJSONString(keyValue);
    }

    protected String modifyValue(String value) {
        return value;
    }

    protected String modifyKey(String key) {
        return key;
    }
}
