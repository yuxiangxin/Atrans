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

package org.xiangxin.atrans;

import java.io.File;
import java.util.Properties;

/**
 * ATO版本信息
 *
 * @author yuxiangxin
 * @since 2021-04-18
 */
public class Config {
    public static final String VERSION = "V1.0";
    public static final String ATRANS_PATH = "atranspath";
    public static final String ENABLE_DEBUG_LOG = "DEBUG_LOG";

    private static final String KEY_VALUE_PATH = "json_parse_config.xml";
    private static final String REPLY_RULE_PATH = "reply_parse_config.xml";

    private String atransPath;
    private boolean enablePrintException;

    public void config(Properties properties) {
        atransPath = properties.getProperty(ATRANS_PATH);
        File pathFile = new File(atransPath);
        if (!pathFile.exists() || !pathFile.isDirectory()) {
            throw new IllegalArgumentException("环境变量配置地址无效, 值必须为目录. " + ATRANS_PATH);
        }
        enablePrintException = "true".equalsIgnoreCase(properties.getProperty(ENABLE_DEBUG_LOG));
    }

    public boolean isEnablePrintException() {
        return enablePrintException;
    }

    public String getJsonParseConfigFile() {
        return new File(atransPath, KEY_VALUE_PATH).getPath();
    }

    public String getReplyParseConfigFile() {
        return new File(atransPath, REPLY_RULE_PATH).getPath();
    }

    public static Config get() {
        return InnerClass.instance;
    }

    static class InnerClass {
        private static final Config instance = new Config();
    }
}
