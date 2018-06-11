package com.vargo.vdk.example.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.vargo.vdk.base.livedata.BaseLiveData;
import com.vargo.vdk.base.viewmodel.BaseViewModel;
import com.vargo.vdk.example.DownloadModel;
import com.vargo.vdk.example.Entity;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 17:33
 */
public abstract class ExampleBaseViewModel extends BaseViewModel<Entity> {
    private DownloadModel mModel;

    ExampleBaseViewModel(@NonNull Application application) {
        super(application);
        mModel = getApplication().getRepository().getModelFactory().create(DownloadModel.class);
    }

    @Override
    protected BaseLiveData<Entity> initLiveData() {
        return new BaseLiveData<>();
    }

    DownloadModel getModel() {
        return mModel;
    }

    public abstract void download();
}
