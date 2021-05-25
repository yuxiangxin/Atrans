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

package org.xiangxin.atrans.data;

/**
 * @author yuxiangxin
 * @since 2021-05-24
 */
public class Attribute {
    private String name;
    private String src;
    private boolean ignoreCase;
    private String mode;
    private String text;

    public String getName () {
        return name;
    }

    public Attribute setName (String name) {
        this.name = name;
        return this;
    }

    public String getSrc () {
        return src;
    }

    public Attribute setSrc (String src) {
        this.src = src;
        return this;
    }

    public boolean isIgnoreCase () {
        return ignoreCase;
    }

    public Attribute setIgnoreCase (boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
        return this;
    }

    public String getMode () {
        return mode;
    }

    public Attribute setMode (String mode) {
        this.mode = mode;
        return this;
    }

    public Attribute setText (String text) {
        this.text = text;
        return this;
    }

    public String getText () {
        return text;
    }
}
