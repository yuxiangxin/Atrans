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

package org.xiangxin.atrans.command.parse;

import org.xiangxin.atrans.command.Command;
import org.xiangxin.atrans.utils.LogUtils;
import org.xiangxin.atrans.utils.NextArray;

/**
 * @author yuxiangxin
 * @since 2021-05-03
 */
public interface ValueParse {
    void parse (NextArray values, Command result);

    default void test (String[] array) {
        try {
            String[] fixArray = new String[array.length + 1];
            System.arraycopy(array, 0, fixArray, 1, array.length);
            fixArray[0] = "base";
            ValueParse handler = getClass().newInstance();
            Command result = new Command();
            handler.parse(new NextArray(fixArray), result);
            LogUtils.v(getClass().getSimpleName(), "result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
