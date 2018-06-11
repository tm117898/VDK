package com.vargo.vdk.base.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vargo.vdk.base.application.ViewModelApplication;
import com.vargo.vdk.base.repository.BaseRepository;
import com.vargo.vdk.base.viewmodel.BaseViewModel;
import com.vargo.vdk.base.viewmodel.ViewModelBaseFactory;


/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/11 10:41
 */
public abstract class ViewModelFragment<T, E extends BaseViewModel<T>> extends BaseFragment implements Observer<T> {
    protected E mModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initViewModel();
        initData();
        return view;
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

    public ViewModelApplication getApplicationContext() {
        return (ViewModelApplication) getActivity().getApplicationContext();
    }

    public BaseRepository getRepository() {
        return getApplicationContext().getRepository();
    }

    public E getViewModel() {
        return mModel;
    }
}
