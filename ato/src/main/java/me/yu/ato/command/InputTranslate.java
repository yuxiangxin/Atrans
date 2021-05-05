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

package me.yu.ato.command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 转换
 *
 * @author yuxiangxin
 * @since 2021-04-23
 */
public class InputTranslate {
    private String chdir;
    private List<File> src = new ArrayList<>();
    private String dst;
    private boolean isCatMode;
    private boolean isHelpMode;

    public String getChdir() {
        return chdir;
    }

    public void setChdir(String chdir) {
        this.chdir = chdir;
    }

    public List<File> getSrc() {
        return src;
    }

    public void setSrc(List<File> src) {
        this.src = src;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public boolean isCatMode() {
        return isCatMode;
    }

    public void setCatMode(boolean catMode) {
        isCatMode = catMode;
    }

    public boolean isHelpMode() {
        return isHelpMode;
    }

    public void setHelpMode(boolean helpMode) {
        isHelpMode = helpMode;
    }

    @Override
    public String toString() {
        return "InputTranslate{" +
                "chdir='" + chdir + '\'' +
                ", dst='" + dst + '\'' +
                ", isCatMode=" + isCatMode +
                ", isHelpMode=" + isHelpMode +
                src != null ?
                ", src=\n" + src.toString().replace(",", ",\n") + " size:" + src.size()
                : ""
                +
                '}';
    }
}
