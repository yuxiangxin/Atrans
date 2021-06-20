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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ATO版本信息
 *
 * @author yuxiangxin
 * @since 2021-04-18
 */
public class Config {
    public static final String VERSION = "V1.0.1";
    public static final String ATRANS_PATH = "atranspath";
    public static final String ENABLE_DEBUG_LOG = "DEBUG_LOG";
    public static final String KEY_VALUE_PATH = "json_parse_config.xml";
    public static final String REPLY_RULE_PATH = "reply_parse_config.xml";

    private TransConfig transConfig;

    public void config (Properties properties) {
        transConfig = new CustomFileConfig(properties);
    }

    public void config (TransConfig config) {
        transConfig = config;
    }

    public boolean isEnablePrintException () {
        return transConfig.enablePrintException();
    }

    public InputStream getJsonParseConfigFile () {
        return transConfig.getJsonParseConfigFile();
    }

    public InputStream getReplyParseConfigFile () {
        return transConfig.getReplyParseConfigFile();
    }

    public static Config get () {
        return InnerClass.instance;
    }

    static class InnerClass {
        private static final Config instance = new Config();
    }

    private static class CustomFileConfig implements TransConfig {
        private String atransPath;
        private boolean enablePrintException;

        public CustomFileConfig (Properties properties) {
            atransPath = properties.getProperty(ATRANS_PATH);
            File pathFile = new File(atransPath);
            if (!pathFile.exists() || !pathFile.isDirectory()) {
                throw new IllegalArgumentException("环境变量配置地址无效, 值必须为目录. " + ATRANS_PATH);
            }
            enablePrintException = "true".equalsIgnoreCase(properties.getProperty(ENABLE_DEBUG_LOG));
        }

        @Override
        public InputStream getJsonParseConfigFile () {
            try {
                return new FileInputStream(new File(atransPath, KEY_VALUE_PATH).getPath());
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override
        public InputStream getReplyParseConfigFile () {
            try {
                return new FileInputStream(new File(atransPath, REPLY_RULE_PATH).getPath());
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override
        public boolean enablePrintException () {
            return enablePrintException;
        }
    }

    public interface TransConfig {
        InputStream getJsonParseConfigFile ();

        InputStream getReplyParseConfigFile ();

        boolean enablePrintException ();
    }
}
