package com.vargo.vdk.base.application;

import android.app.Application;
import android.content.Context;

import com.vargo.vdk.base.repository.BaseRepository;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/06 17:47
 */
public abstract class ViewModelApplication<R extends BaseRepository> extends Application {
    private R mRepository;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mRepository = initRepository();
    }

    protected abstract R initRepository();

    public R getRepository() {
        return mRepository;
    }
}
