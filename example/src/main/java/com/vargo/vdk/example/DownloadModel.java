package com.vargo.vdk.example;

import com.vargo.vdk.base.application.ViewModelApplication;
import com.vargo.vdk.base.model.BaseModel;
import com.vargo.vdk.example.utils.DownloadUtil;
import com.vargo.vdk.utils.bitmap.BitmapUtil;

import java.io.IOException;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 10:23
 */
public class DownloadModel extends BaseModel {
    public static final String URL = "https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=8cd25e6c8e94a4c21e2eef796f9d70b0/c995d143ad4bd11329aa085153afa40f4bfb0569.jpg";
    public final String IMG_SAVE_PATH;

    public DownloadModel(ViewModelApplication application) {
        super(application);
        IMG_SAVE_PATH = application.getExternalCacheDir() + "/mg.jpg";
    }

    public Entity download() throws IOException {
        if (DownloadUtil.download(URL, IMG_SAVE_PATH)) {
            int[] wh = BitmapUtil.decodeBitmapSize(IMG_SAVE_PATH);
            return Entity.getSuccessEntity(IMG_SAVE_PATH, wh[0], wh[1]);
        }

        return Entity.getFiledEntity();
    }
}
