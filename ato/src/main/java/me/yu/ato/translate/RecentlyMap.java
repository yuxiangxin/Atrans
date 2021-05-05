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

import java.util.Arrays;
import java.util.Optional;

/**
 * 自动将最近使用的数据排序至第一位, 以便下次可以迅速取出最近使用过的数据
 *
 * @author yuxiangxin
 * @since 2021-05-05
 */
public class RecentlyMap<V> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE / 2;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    private Object[] values;
    private String[] keys;
    private int size;

    public RecentlyMap() {
        this.keys = new String[DEFAULT_CAPACITY];
        this.values = new Object[DEFAULT_CAPACITY];
    }

    public void put(String key, V value) {
        if (index(key) != -1) {
            throw new IllegalArgumentException("Already exist the key: " + key);
        }
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        int addIndex = size++;
        values[addIndex] = value;
        keys[addIndex] = key;
    }

    public Optional<V> get(String key) {
        int index = index(key);
        if (index != -1) {
            //noinspection unchecked
            V data = (V) values[index];
            if (index != 0) {
                setToFirst(keys, index);
                setToFirst(values, index);
            }
            return Optional.of(data);
        }
        return Optional.empty();
    }

    private void setToFirst(Object[] array, int index) {
        int size = array.length;
        Object targetValue = array[index];
        System.arraycopy(array, 0, array, 1, Math.min(index, size));
        array[0] = targetValue;
    }

    private int index(String key) {
        if (key.equals(keys[0])) {
            return 0;
        }
        for (int i = 1; i < size; i++) {
            if (key.equals(keys[i])) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(values, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        size++;
        // overflow-conscious code
        if (minCapacity - values.length > 0) {
            grow(minCapacity);
        }
    }


    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }


    private void grow(int minCapacity) {
        int oldCapacity = values.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        values = Arrays.copyOf(values, newCapacity);
        keys = Arrays.copyOf(keys, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
}
