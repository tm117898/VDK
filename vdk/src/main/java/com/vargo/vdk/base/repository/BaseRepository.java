package com.vargo.vdk.base.repository;

import com.vargo.vdk.base.application.ViewModelApplication;
import com.vargo.vdk.base.model.ModelBaseFactory;
import com.vargo.vdk.base.viewmodel.ViewModelBaseFactory;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/06 17:48
 */
public abstract class BaseRepository<ViewModelFactory extends ViewModelBaseFactory, ModelFactory extends ModelBaseFactory> {
    private ViewModelApplication mApplication;
    private ViewModelFactory mViewModelFactory;
    private ModelFactory mModelFactory;

    public BaseRepository(ViewModelApplication a) {
        mApplication = a;
    }

    public ViewModelApplication getApplication() {
        return mApplication;
    }

    public synchronized ViewModelFactory getViewModelFactory() {
        if (mViewModelFactory == null) {
            mViewModelFactory = initViewModelFactory();
        }
        return mViewModelFactory;
    }

    protected abstract ViewModelFactory initViewModelFactory();

    public synchronized ModelFactory getModelFactory() {
        if (mModelFactory == null) {
            mModelFactory = initModelFactory();
        }
        return mModelFactory;
    }

    protected abstract ModelFactory initModelFactory();
}
