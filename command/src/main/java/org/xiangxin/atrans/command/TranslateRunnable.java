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

package org.xiangxin.atrans.command;

import org.xiangxin.atrans.translate.FileOutputWriter;
import org.xiangxin.atrans.translate.Interpreter;
import org.xiangxin.atrans.translate.SystemOutPrinter;
import org.xiangxin.atrans.utils.Utils;

import java.io.File;
import java.util.List;

/**
 * 转换执行任务
 *
 * @author yuxiangxin
 * @since 2021-05-23
 */
public class TranslateRunnable implements Runnable {
    private Command command;

    public TranslateRunnable (Command command) {
        this.command = command;
    }

    @Override
    public void run () {
        boolean isCat = command.isCatMode();
        List<File> src = command.getSrc();
        for (File file : src) {
            try {
                System.out.println(file.getName());
                File dst = new File(Utils.getNotNull(command.getDst(), file.getParent()), "atrans_" + file.getName());
                new Interpreter(file, isCat ? new SystemOutPrinter() : new FileOutputWriter(dst)).translate(command.getParser());
                System.out.print(file.getName() + "转换已完成");
                if (!isCat) {
                    System.out.println(", 结果保存至: " + dst.getPath());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
