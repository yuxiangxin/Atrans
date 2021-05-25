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

package org.xiangxin.atrans.data;import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiangxin on 2020/08/23
 * 描述: io流操作
 */
public class IoUtils {
    private static final String TAG = "IOUtil";
    public static final String UTF_8 = "UTF-8";
    public static final String DEFAULT_BACKUP_NAME = "backup";

    public static void filterFile (File dir, FileFilter fileFilter, List<File> list) {
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        filterFile(file, fileFilter, list);
                    } else {
                        if (fileFilter.accept(file)) {
                            list.add(file);
                        }
                    }
                }
            }
        } else {
            if (fileFilter.accept(dir)) {
                list.add(dir);
            }
        }
    }

    public static void filterFileWithDir (File file, FileFilter fileFilter, ArrayList<File> list) {
        if (file == null || !file.exists()) {
            return;
        }
        if (fileFilter.accept(file)) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File eachFile : files) {
                        filterFileWithDir(eachFile, fileFilter, list);
                    }
                }
            } else {
                if (fileFilter.accept(file)) {
                    list.add(file);
                }
            }
        }
    }

    public static ArrayList<File> filterFile (File dir, final String... format) {
        ArrayList<File> list = new ArrayList<>();
        filterFile(dir, new FileFormatFilter(format), list);
        return list;
    }

    public static void filterFile (File dir, ArrayList<File> list, final FileFilter andFilter, final String... format) {
        filterFile(dir, new FileFormatFilter(format) {
            @Override
            public boolean accept (File pathname) {
                if (andFilter != null) {
                    return super.accept(pathname) && andFilter.accept(pathname);
                }
                return super.accept(pathname);
            }
        }, list);
    }

    public static class FileFormatFilter implements FileFilter {
        private String[] format;

        public FileFormatFilter (String[] format) {
            this.format = format;
        }

        @Override
        public boolean accept (File pathname) {
            for (String txtItem : format) {
                if (pathname.getName().endsWith(txtItem)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class IgnoreDirFilter implements FileFilter {
        private String backupMkdir;

        public IgnoreDirFilter (String backupMkdir) {
            this.backupMkdir = backupMkdir;
        }

        @Override
        public boolean accept (File pathname) {
            return !pathname.getParent().contains(backupMkdir);
        }
    }


    public static void deleteFileOrDir (File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File fileItem : files) {
                    deleteFileOrDir(fileItem);
                }
                file.delete();
            } else {
                file.delete();
            }
        }
    }

    /**
     * 复制文件 a -> dir
     */
    public static void copyFileKeepName (File file, File fileDir) throws IOException {
        copyFile(file, new File(
                fileDir.getAbsoluteFile(), file.getName()));
    }

    /**
     * 复制文件 a -> b
     */
    public static void copyFile (File file, File newFile) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            out = new BufferedOutputStream(new FileOutputStream(newFile));
            streamReadWrite(in, out);
        } finally {
            ioClose(in, out);
        }
    }


    public static void streamReadWrite (BufferedInputStream in, BufferedOutputStream out) throws IOException {
        int len = -1;
        while ((len = in.read()) != -1) {
            out.write(len);
        }
    }

    public static void streamReadWrite (InputStream in, OutputStream out) throws IOException {
        streamReadWrite(new BufferedInputStream(in), new BufferedOutputStream(out));
    }

    public final static String RN = "\r\n";

    public static InputStream openFileStream (File file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getContent (InputStream in, String encode, boolean readFirstline) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    in, encode));
            if (readFirstline) {
                return reader.readLine();
            }
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + RN);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String getContent (InputStream in) {
        return getContent(in, UTF_8, false);
    }

    public static String getContent (InputStream in, String endoce) {
        return getContent(in, endoce, false);
    }

    public static String getFirstLine (InputStream in) {
        return getContent(in, UTF_8, true);
    }


    public static String getFirstLine (InputStream in, String encode) {
        return getContent(in, encode, true);
    }

    public static String getFirstLine (File file) {
        return getFirstLine(openFileStream(file));
    }

    public static void charReadWrite (BufferedReader in, BufferedWriter out) throws IOException {
        String line = null;
        while ((line = in.readLine()) != null) {
            out.write(line);
        }
    }


    public static void charReadWrite (Reader in, Writer out) throws IOException {
        charReadWrite(new BufferedReader(in), new BufferedWriter(out));
    }


    public static String getFileContentByReader (InputStreamReader in) throws IOException {
        return getFileContentByBufferedReader(new BufferedReader(in));
    }


    public static String getFileContentByBufferedReader (BufferedReader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = in.readLine()) != null) {
            sb.append(line + "\r\n");
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.substring(0, sb.length() - 2);
    }


    public static String getFileContext (File file, String coding) throws IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file), coding));
            return getFileContentByBufferedReader(in);
        } finally {
            ioClose(in);
        }
    }


    public static String getFileContent (File file) throws IOException {
        return getFileContext(file, "UTF-8");
    }


    public static String getFileContent (File file, String coding) throws IOException {
        return getFileContext(file, coding);
    }

    public static void writeContent (String content, File file, boolean append) throws IOException {
        writeContent(content, UTF_8, file, append);
    }


    public static synchronized void writeContent (String content, String coding, File file, boolean append) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, append), coding));
            out.write(content);
        } finally {
            ioClose(out);
        }
    }


    public static void copyFile (File file, File fileDir, String newFileName) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            out = new BufferedOutputStream(new FileOutputStream(new File(
                    fileDir.getAbsoluteFile(), newFileName)));
            streamReadWrite(in, out);
        } finally {
            ioClose(in, out);
        }
    }

    public static void copyDir (File sourceDir, File targetDir) throws IOException {
        if (sourceDir.equals(targetDir)) {
            throw new RuntimeException("Same dir!");
        }
        File newDir = new File(targetDir.getAbsolutePath(), sourceDir.getName());
        if (newDir.mkdirs()) {
            File[] files = sourceDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        copyDir(f, newDir);
                    } else if (f.isFile()) {
                        copyFile(f, new File(newDir, f.getName()));
                    }
                }
            }
        } else {
            System.out.println("The fileDir has been exist");
        }
    }

    public static void delFile (File file) {
        if (file != null && file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void ioClose (Closeable... in) {
        if (in == null)
            return;
        for (Closeable closeable : in) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    //doNothing
                }
            }
        }
    }

    public static String getExtension (File file) {
        final String name = file.getName().toLowerCase();
        final int i = name.lastIndexOf(".");
        if (i == -1) {
            return "";
        }
        return name.substring(i + 1);
    }


    public static InputStream getUrlInputStream (String url) throws IOException {
        if (url == null) {
            throw new NullPointerException("url is null");
        }
        URLConnection con = new URL(url).openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        HttpURLConnection conn = (HttpURLConnection) con;
        conn.setRequestMethod("GET");
        conn.setReadTimeout(000);
        conn.setConnectTimeout(30000);
        return conn.getInputStream();
    }


}
