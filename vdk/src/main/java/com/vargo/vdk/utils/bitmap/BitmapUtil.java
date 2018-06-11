package com.vargo.vdk.utils.bitmap;

import android.graphics.BitmapFactory;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 15:42
 */
public class BitmapUtil {
    private static BitmapFactory.Options getMeasureOptions() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        return options;
    }

    public static int[] decodeBitmapSize(String path) {
        BitmapFactory.Options options = getMeasureOptions();
        BitmapFactory.decodeFile(path, options);
        return new int[]{options.outWidth, options.outHeight};
    }
}
