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

/**
 * 顺序取值的数组
 *
 * @author yuxiangxin
 * @since 2021-05-01
 */
public class NextArray {
    public int currentPosition;
    private final String[] values;

    public NextArray(String[] values) {
        this.values = values;
    }

    public boolean hasNext() {
        return !isEmptyPosition(currentPosition + 1);
    }

    public NextArray next() {
        currentPosition++;
        return this;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public boolean isEmpty() {
        return values == null || values.length == 0;
    }

    public String[] getValues() {
        return values;
    }

    public int size() {
        return isEmpty() ? 0 : values.length;
    }

    public String get() {
        return values[currentPosition];
    }

    public boolean hasValue() {
        return isEmptyPosition(currentPosition);
    }

    private boolean isEmptyPosition(int position) {
        return position >= values.length;
    }

    public void move(int move) {
        currentPosition += move;
    }
}
