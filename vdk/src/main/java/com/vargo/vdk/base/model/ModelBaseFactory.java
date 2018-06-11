package com.vargo.vdk.base.model;

import android.support.annotation.NonNull;

import com.vargo.vdk.base.application.ViewModelApplication;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 10:27
 */
public abstract class ModelBaseFactory {
    protected ViewModelApplication mApplication;

    public ModelBaseFactory(ViewModelApplication a) {
        this.mApplication = a;
    }

    public ViewModelApplication getApplication() {
        return mApplication;
    }

    public <T extends BaseModel> T create(@NonNull Class<T> modelClass) {
        T t = onCreate(modelClass);
        if (t != null) {
            return t;
        }

        t = createInstance(modelClass);
        if (t != null) {
            return t;
        }

        throw new NullPointerException("not support " + modelClass.getName() + " create");

    }

    private <T extends BaseModel> T createInstance(@NonNull Class<T> modelClass) {
        //noinspection TryWithIdenticalCatches
        try {
            return modelClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        }
    }

    protected abstract <T extends BaseModel> T onCreate(Class<T> modelClass);
}
