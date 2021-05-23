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

package org.xiangxin.atrans.translate.impl.reply.bean;

import org.dom4j.Element;
import org.xiangxin.atrans.translate.impl.json.ParserLoader;
import org.xiangxin.atrans.translate.impl.reply.Reply;
import org.xiangxin.atrans.utils.LogUtils;
import org.xiangxin.atrans.utils.Utils;

import lombok.Data;

/**
 * @author yuxiangxin
 * @since 2021-05-22
 */
@Data
public class ReplyRuleBean implements Value {
    @Reply(checkNull = true)
    private String name;
    @Reply(defaultValue = ParserLoader.STRING_FALSE)
    private String ignoreCase;
    @Reply(defaultValue = ParserLoader.MODE_CONTAINS)
    private String mode;
    @Reply(checkNull = true)
    private String src;

    private String value;

    private Element element;
    private NodeItemValue nodeItemValue;

    @Override
    public boolean isValid() {
        return !Utils.isEmpty(name) && !Utils.isEmpty(value);
    }

    @Override
    public void apply() {
        if (!isValid()) {
            throw new IllegalArgumentException("The name or value uninitialized:" + name + " " + value);
        }
        boolean isIgnoreCase = ParserLoader.STRING_TRUE.equals(ignoreCase);

        if (ParserLoader.MODE_WORD.equals(mode)) {
            if (isIgnoreCase) {
                nodeItemValue = new IgnoreCaseWordMatchValue(src, value);
            } else {
                nodeItemValue = new WordMatchValue(src, value);
            }
        } else {
            if (isIgnoreCase) {
                nodeItemValue = new IgnoreCaseContainsValue(src, value);
            } else {
                nodeItemValue = new ContainsValue(src, value);
            }
        }
    }

    public String reply(String content) {
        if (nodeItemValue != null && nodeItemValue.isMatch(content)) {
            return nodeItemValue.reply(content);
        }
        return content;
    }

    public static void main(String[] args) {
        ReplyRuleBean test = new ReplyRuleBean();
        test.setName("elementValue");
        test.setSrc("dp");
        test.setValue("vp");
        test.setIgnoreCase("true");
        test.setMode(ParserLoader.MODE_WORD);
        String reply = test.reply("111dp");
        LogUtils.v("TAG", "" + reply);
    }
}
