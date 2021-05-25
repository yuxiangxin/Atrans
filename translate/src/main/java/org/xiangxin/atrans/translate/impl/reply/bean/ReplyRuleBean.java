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
    @Reply(defaultValue = ParserLoader.MODE_CONTAINS_MATCH)
    private String mode;
    @Reply(checkNull = true)
    private String src;

    private String value;

    private Element element;
    private NodeItemValue nodeItemValue;

    @Override
    public boolean isValid () {
        return !Utils.isEmpty(name) && !Utils.isEmpty(value);
    }

    @Override
    public void apply () {
        if (!isValid()) {
            throw new IllegalArgumentException("The name or value not initialized:" + name + " " + value);
        }
        boolean isIgnoreCase = ParserLoader.STRING_TRUE.equals(ignoreCase);
        if (isIgnoreCase) {
            switch (mode) {
                case ParserLoader.MODE_WORD_ALL:
                    nodeItemValue = new IgnoreCaseWordAllValue(src, value);
                    break;
                case ParserLoader.MODE_CONTAINS_MATCH:
                    nodeItemValue = new IgnoreCaseContainsMatchValue(src, value);
                    break;
                case ParserLoader.MODE_CONTAINS_ALL:
                    nodeItemValue = new IgnoreCaseContainsAllValue(src, value);
                    break;
                default:
                    throwModeErrorException();
            }
        } else {
            switch (mode) {
                case ParserLoader.MODE_WORD_ALL:
                    nodeItemValue = new WordAllValue(src, value);
                    break;
                case ParserLoader.MODE_CONTAINS_MATCH:
                    nodeItemValue = new ContainsMatchValue(src, value);
                    break;
                case ParserLoader.MODE_CONTAINS_ALL:
                    nodeItemValue = new ContainsAllValue(src, value);
                    break;
                default:
                    throwModeErrorException();
            }
        }
    }

    private void throwModeErrorException () {
        String inMode = String.format(
                "[%s|%s|%s]",
                ParserLoader.MODE_CONTAINS_MATCH,
                ParserLoader.MODE_CONTAINS_ALL,
                ParserLoader.MODE_WORD_ALL
        );
        throw new IllegalArgumentException("替换模式不正确 " + element.asXML() + "  mode:" + mode + " 不正确,必须为:" + inMode);
    }

    public String reply (String content) {
        if (nodeItemValue != null && nodeItemValue.isMatch(content)) {
            return nodeItemValue.reply(content);
        }
        return content;
    }
//    <reply name="attributeValue" src="@+id/" mode="contains_match">$+id:</reply>
//    <reply name="attributeValue" src="@id/" mode="contains_match">$id:</reply>
    public static void main (String[] args) {
        ReplyRuleBean test = new ReplyRuleBean();
        test.setName("elementValue");
        test.setSrc("@+id/");
        test.setValue("$+id:");
        //test.setIgnoreCase("true");
        test.setMode(ParserLoader.MODE_CONTAINS_MATCH);
        test.apply();
        String reply = test.reply("@+id/reply_ll");
        LogUtils.v("TAG", "" + reply);
    }
}
