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

package me.yu.ato;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author yuxiangxin
 * @since 2021-05-04
 */
public class Test {

    private static final String TAG = "Test";

    public static void main(String[] args) throws IOException {

        Integer[] integers = {1, 2, 3, 4, 5, 6, 7};
        sortToFirst(integers, 1);
        System.out.println(Arrays.toString(integers));
    }


    private static void sortToFirst(Object[] array, int index) {
        System.out.println(Arrays.toString(array));
        int size = array.length;
        Object targetValue = array[index];
        System.arraycopy(array, 0, array, 1, Math.min(index, size));
        array[0] = targetValue;
    }
}
