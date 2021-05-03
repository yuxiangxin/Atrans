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

package me.yu.ato.commandparse;

import java.io.File;

import me.yu.ato.NextArray;
import me.yu.ato.command.InputTranslate;

/**
 * 保存目录解析
 *
 * @author yuxiangxin
 * @since 2021-05-03
 */
public class DstValueParse implements ValueParse {
    @Override
    public void parse(NextArray values, InputTranslate result) {
        String value = values.next().get();
        File saveFile = new File(value);
        if (!saveFile.isDirectory()) {
            throw new InputErrorException("此处仅能为目录", value);
        }
        if (!saveFile.exists()) {
            boolean mkdirs = saveFile.mkdirs();
            if (!mkdirs) {
                throw new CannotParseException("保存目录创建失败!", value);
            }
        }
        if (!saveFile.canWrite()) {
            throw new CannotParseException("保存目录无写入权限!", value);
        }
        result.setDst(value);
    }
}
