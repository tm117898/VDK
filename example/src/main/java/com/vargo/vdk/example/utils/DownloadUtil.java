package com.vargo.vdk.example.utils;

import com.vargo.vdk.utils.io.FileUtil;
import com.vargo.vdk.utils.net.NetUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 15:32
 */
public class DownloadUtil {
    public static boolean download(String url, String savePath) throws IOException {
        FileUtil.delete(savePath);

        HttpURLConnection conn = null;
        try {
            conn = NetUtil.openConnection(url);
            InputStream is = conn.getInputStream();
            if (FileUtil.copy(is, savePath)) {
                return true;
            }
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return false;
    }
}
