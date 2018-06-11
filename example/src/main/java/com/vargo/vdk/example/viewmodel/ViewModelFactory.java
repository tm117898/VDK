package com.vargo.vdk.example.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.vargo.vdk.base.application.ViewModelApplication;
import com.vargo.vdk.base.viewmodel.ViewModelBaseFactory;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/07 14:02
 */
public class ViewModelFactory extends ViewModelBaseFactory {
    public ViewModelFactory(ViewModelApplication a) {
        super(a);
    }

    @Override
    protected <T extends ViewModel> T onCreate(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LegacyViewModel.class)) {
            return (T) new LegacyViewModel(getApplication());
        } else if (modelClass.isAssignableFrom(RxViewModel.class)) {
            return (T) new RxViewModel(getApplication());
        }
        return null;
    }
}
