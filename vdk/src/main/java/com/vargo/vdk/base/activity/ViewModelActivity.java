package com.vargo.vdk.base.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vargo.vdk.base.application.ViewModelApplication;
import com.vargo.vdk.base.repository.BaseRepository;
import com.vargo.vdk.base.viewmodel.BaseViewModel;
import com.vargo.vdk.base.viewmodel.ViewModelBaseFactory;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/06 19:01
 */
public abstract class ViewModelActivity<T, E extends BaseViewModel<T>> extends BaseActivity implements Observer<T> {
    protected E mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
        initData();
    }

    protected void initViewModel() {
        ViewModelBaseFactory f = getRepository().getViewModelFactory();
        mModel = (E) new ViewModelProvider(this, f).get(getViewModelClass());
        mModel.register(this, this);
    }

    protected abstract Class<? extends BaseViewModel> getViewModelClass();

    /**
     * 初始化数据
     */
    public void initData() {
    }

    @Override
    public ViewModelApplication getApplicationContext() {
        return (ViewModelApplication) super.getApplicationContext();
    }

    public BaseRepository getRepository() {
        return getApplicationContext().getRepository();
    }

    public E getViewModel() {
        return mModel;
    }
}
