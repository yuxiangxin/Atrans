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

/**
 * ATO版本信息
 *
 * @author yuxiangxin
 * @since 2021-04-18
 */
public interface BuildConfig {
    String VERSION = "V1.0";
    String RUN_PATH = System.getProperty("user.dir");
    String KEY_VALUE_PATH = RUN_PATH + "\\json_parser_config.xml";
    String REPLY_RULE_PATH = RUN_PATH + "\\reply_rule_config.xml";
}
