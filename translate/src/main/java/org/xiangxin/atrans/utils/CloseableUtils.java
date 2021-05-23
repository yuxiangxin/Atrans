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

package org.xiangxin.atrans.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by yuxiangxin on 2020/08/23
 * 描述: io流操作
 */
public class CloseableUtils {
    public static void ioClose (Closeable... in) {
        if (in == null)
            return;
        for (Closeable closeable : in) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    //doNothing
                }
            }
        }
    }
}
