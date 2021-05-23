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

package org.xiangxin.atrans.translate.impl.reply;

import org.dom4j.Element;
import org.xiangxin.atrans.translate.UnSupportTranslateType;
import org.xiangxin.atrans.translate.impl.reply.bean.Value;
import org.xiangxin.atrans.utils.Utils;

import java.lang.reflect.Field;

/**
 * @author yuxiangxin
 * @since 2021-05-07
 */
public class OfElement<E extends Value> {
    private Element element;
    private E obj;
    private Class<?> objClz;

    public OfElement(Element element, E obj) {
        this.element = element;
        this.obj = obj;
        objClz = obj.getClass();
    }

    public OfElement<E> apply() {
        Field[] filed = objClz.getDeclaredFields();
        for (Field field : filed) {
            Reply annotation = field.getAnnotation(Reply.class);
            if (annotation != null) {
                String attrName = Utils.getDefault(annotation.name(), field.getName());
                apply(field.getName(), attrName, annotation.defaultValue());
            }
        }
        obj.setValue(element.getStringValue());
        obj.setElement(element);
        obj.apply();
        return this;
    }

    private void apply(String fieldName, String attributeName, String defaultValue) {
        String value = element.attributeValue(attributeName, defaultValue);
        try {
            Field field = objClz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException e) {
            throw new UnSupportTranslateType("未找到字段:" + attributeName);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public E get() {
        return obj;
    }
}
