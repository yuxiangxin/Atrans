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

package org.xiangxin.atrans.translate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件写入处理者
 *
 * @author yuxiangxin
 * @since 2021-05-23
 */
public class FileOutputWriter implements Printer {
    private FileWriter writer;

    public FileOutputWriter (File out) throws IOException {
        writer = new FileWriter(out, false);
    }

    @Override
    public void println (String content) throws IOException {
        writer.write(content);
    }

    @Override
    public void close () throws IOException {
        writer.flush();
        writer.close();
    }
}
