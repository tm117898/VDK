package com.vargo.vdk.base.model;

import com.vargo.vdk.base.application.ViewModelApplication;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 10:24
 */
public class BaseModel {
    private ViewModelApplication application;

    public BaseModel(ViewModelApplication application) {
        this.application = application;
    }

    public ViewModelApplication getApplication() {
        return application;
    }
}
