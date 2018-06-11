package com.vargo.vdk.utils.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 14:30
 */
public class NetUtil {
    public static final int TIME_OUT_TIME = 5000;

    public static HttpURLConnection openConnection(String url) throws IOException {
        URL u = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) u.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(TIME_OUT_TIME);
        connection.setReadTimeout(TIME_OUT_TIME);
        return connection;
    }
}
