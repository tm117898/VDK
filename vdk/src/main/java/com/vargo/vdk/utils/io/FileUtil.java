package com.vargo.vdk.utils.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 14:42
 */
public class FileUtil {
    private static final int BUFFER_SIZE = 1024;

    public static boolean delete(String path) {
        return delete(new File(path));
    }

    public static boolean delete(File file) {
        boolean result = true;
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                for (int i = 0, size = children.length; i < size; i++) {
                    result &= delete(children[i]);
                }
            } else {
                result = file.delete();
            }
        }
        return result;
    }

    public static boolean copy(InputStream from, String to) throws IOException {
        return copy(from, new File(to));
    }

    public static boolean copy(InputStream from, File to) throws IOException {
        if (makeFile(to)) {
            try (
                    InputStream is = from;
                    OutputStream os = new FileOutputStream(to)
            ) {
                long nread = copy(is, os);
                return nread > 0;
            }
        }
        return false;
    }

    public static long copy(InputStream from, OutputStream to) throws IOException {
        long nread = 0L;
        byte[] buf = new byte[BUFFER_SIZE];
        int n;
        while ((n = from.read(buf)) > 0) {
            to.write(buf, 0, n);
            nread += n;
        }
        return nread;
    }

    public static boolean makeFile(File file) throws IOException {
        File parent = file.getParentFile();
        if (makeDirectory(parent)) {
            return file.createNewFile();
        }
        return false;
    }

    public static boolean makeDirectory(File file) {
        if (file.exists()) {
            return true;
        } else {
            return file.mkdirs();
        }
    }
}
