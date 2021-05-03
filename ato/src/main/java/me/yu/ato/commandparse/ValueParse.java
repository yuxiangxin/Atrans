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

package me.yu.ato.commandparse;

import me.yu.ato.NextArray;
import me.yu.ato.command.InputTranslate;
import me.yu.ato.utils.LogUtils;

/**
 * @author yuxiangxin
 * @since 2021-05-03
 */
public interface ValueParse {
    void parse(NextArray values, InputTranslate result);

    default void test(String[] array) {
        try {
            String[] fixArray = new String[array.length + 1];
            System.arraycopy(array, 0, fixArray, 1, array.length);
            fixArray[0] = "base";
            ValueParse handler = getClass().newInstance();
            InputTranslate result = new InputTranslate();
            handler.parse(new NextArray(fixArray), result);
            LogUtils.v(getClass().getSimpleName(), "result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
