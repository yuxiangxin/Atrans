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

package me.yu.ato.build;

import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NoPermissionException;

import me.yu.ato.BuildConfig;

/**
 * 1.抽取ato编译的jar包,重新解压缩,重写Main配置文件, 以便支持Main函数
 * 2.生成aot.bat文件
 *
 * @author yuxiangxin
 * @since 2021-04-17
 */
public class Build {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String mainClass = BuildConfig.MAIN_CLASS;
        String classLib = null;
        try {
            new Config(projectPath, mainClass)
                    .version(BuildConfig.VERSION)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Config {
        // 源jar相对路径
        private static final String SRC_JAR_ABS_PATH = "ato\\build\\libs\\ato.jar";
        // build保存相对路径
        private static final String DST_ABS_DIR = "bin";

        private static final String DST_JAR_NAME = "ato";
        // build Bat相对路径
        private static final String BAT_NAME = "ato.bat";

        private static final String MANIFEST_PATH_FORMAT = "%s/META-INF/MANIFEST.MF";

        private static final String VERSION_REGEX = "(?i)v?\\d+(.\\d+)*?[ a-zA-Z]{0,6}";
        private static final String DEFAULT_VERSION = "V1.0";

        // 项目路径
        private String projectPath;
        // 版本号
        private String version;
        // 编译日期, 自动生成
        private String buildDate;
        // Main函数路径
        private String mainClass;
        // 依赖的第三方库
        private String classLib;

        private String dstJarPath;
        private String dstBatPath;

        @SuppressWarnings("SimpleDateFormat")
        public Config(String projectPath, String mainClass) {
            this.projectPath = projectPath;
            this.mainClass = mainClass;
            buildDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
        }

        public Config version(String version) {
            this.version = version;
            return this;
        }

        public Config setClassLib(String classLib) {
            this.classLib = classLib;
            return this;
        }

        public void build() throws IOException, NoPermissionException {
            // 输入有效性检查
            File projectFile = new File(projectPath);
            if (!projectFile.exists()) {
                throw new FileNotFoundException("File 'projectPath' not found!");
            }
            if (mainClass == null) {
                throw new NullPointerException();
            }

            if (version == null) {
                version = DEFAULT_VERSION;
            } else {
                if (!version.matches(VERSION_REGEX)) {
                    throw new IllegalArgumentException("The Params 'version' is incorrect");
                }
            }
            File srcJarFile = new File(projectFile + "\\" + SRC_JAR_ABS_PATH);
            if (!srcJarFile.exists()) {
                throw new FileNotFoundException("Jar not found, Please build the jar library");
            }

            File dstDir = new File(projectFile + "\\" + DST_ABS_DIR);
            resetDir(dstDir);
            if (!dstDir.exists()) {
                throw new NoPermissionException("Create build file failed, Please check current user permission");
            }

            String dstJarName = DST_JAR_NAME + "_" + version + ".jar";
            dstJarPath = String.format("%s\\%s", DST_ABS_DIR, dstJarName);
            dstBatPath = new File(dstDir, BAT_NAME).getPath();

            // 清理历史旧数据记录
            File dstJar = new File(dstJarPath);
            File dstBat = new File(dstBatPath);
            IoUtils.delFile(dstJar);
            IoUtils.delFile(dstBat);

            StringBuilder manifestBuilder = new StringBuilder()
                    .append("Manifest-Version: 1.0\n")
                    .append("Build-Jdk: 1.8.0_251\n")
                    .append("Main-Class: ").append(mainClass).append("\n");
            if (classLib != null) {
                manifestBuilder.append("Class-Path: ").append(classLib).append("\n");
            }
            manifestBuilder.append("\n");

            File tempUnPack = new File(dstDir, "tempUnPack");
            try {
                resetDir(tempUnPack);
                ZipUtil.unpack(srcJarFile, tempUnPack);
                System.out.println("tempUnPack" + tempUnPack.exists());
                System.out.println("tempUnPack" + tempUnPack.getPath());
                File mainFile = new File(String.format(MANIFEST_PATH_FORMAT, tempUnPack.getPath()));
                IoUtils.writeContent(manifestBuilder.toString(), mainFile, false);

                ZipUtil.pack(tempUnPack, dstJar, false);

                // 生成新的bat文件
                String batContent = new BatContentBuilder(version, buildDate, dstJarName).build();
                IoUtils.writeContent(batContent, dstBat, false);
                System.out.println(dstDir);
            } finally {
                IoUtils.deleteFileOrDir(tempUnPack);
            }
        }

        private void resetDir(File dir) {
            if (dir.exists()) {
                for (File file : dir.listFiles()) {
                    IoUtils.deleteFileOrDir(file);
                }
            } else {
                dir.mkdirs();
            }
        }
    }

    private static class BatContentBuilder {
        private final String version;
        private final String buildDate;
        private final String jarName;

        public BatContentBuilder(String version, String buildDate, String jarName) {
            this.version = version;
            this.buildDate = buildDate;
            this.jarName = jarName;
        }

        public String build() {
            String rem = String.format("@ECHO OFF\n" +
                            "REM ATO(Android to OHOS) start bat\n" +
                            "REM Version: %s\n" +
                            "REM Build date: %s\n\n"
                    , version, buildDate);
            StringBuilder contentBuilder = new StringBuilder(rem)
                    .append("JAVA -jar .\\")
                    .append(jarName)
                    .append(" %cd% ");
            for (int i = 1; i < 10; i++) {
                contentBuilder.append("%").append(i).append(" ");
            }
            contentBuilder.append("\n")
                    .append("pause");
            return contentBuilder.toString();
        }
    }
}