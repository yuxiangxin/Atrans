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

import org.xiangxin.atrans.BuildConfig;
import org.xiangxin.atrans.utils.IoUtils;
import org.xiangxin.atrans.utils.LogUtils;

import java.io.InputStream;

/**
 * @author yuxiangxin
 * @since 2021-05-23
 */
public class PrintGuideRunnable implements Runnable {
    private static final String TAG = "PrintGuideRunnable";

    @Override
    public void run () {
        try {
            InputStream stream = PrintGuideRunnable.class
                    .getClassLoader().getResourceAsStream("guide.txt");
            String guideContent = IoUtils.getContent(stream);
            guideContent = guideContent.replaceFirst("\\{version}", "version:" + BuildConfig.VERSION);
            System.out.println(guideContent);
        } catch (Exception e) {
            LogUtils.e(TAG, "使用指南文件丢失!");
        }
    }
}
