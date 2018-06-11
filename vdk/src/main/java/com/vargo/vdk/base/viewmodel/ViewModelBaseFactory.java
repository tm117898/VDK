package com.vargo.vdk.base.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.vargo.vdk.base.application.ViewModelApplication;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/06 17:51
 */
public abstract class ViewModelBaseFactory extends ViewModelProvider.NewInstanceFactory {
    protected ViewModelApplication mApplication;

    public ViewModelBaseFactory(ViewModelApplication a) {
        this.mApplication = a;
    }

    public ViewModelApplication getApplication() {
        return mApplication;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T t = onCreate(modelClass);
        if (t != null) {
            return t;
        }

        t = super.create(modelClass);
        if (t != null) {
            return t;
        }

        throw new NullPointerException("not support " + modelClass.getName() + " create");
    }

    protected abstract <T extends ViewModel> T onCreate(Class<T> modelClass);
}
