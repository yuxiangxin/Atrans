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

import java.io.File;
import java.util.Optional;

/**
 * 文件操作
 *
 * @author yuxiangxin
 * @since 2021-05-10
 */
public class FileUtils {
    public static Optional<String> getFileExt(File file) {
        if (file == null || file.isDirectory() || !file.exists()) {
            return Optional.empty();
        }
        String name = file.getName();
        int lastIndex = name.lastIndexOf(".");
        if (lastIndex == -1) {
            return Optional.empty();
        }
        return Optional.of(name.substring(lastIndex + 1));
    }
}
