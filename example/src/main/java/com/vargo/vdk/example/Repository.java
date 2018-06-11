package com.vargo.vdk.example;


import com.vargo.vdk.base.application.ViewModelApplication;
import com.vargo.vdk.base.repository.BaseRepository;
import com.vargo.vdk.example.viewmodel.ViewModelFactory;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/07 13:58
 */
public class Repository extends BaseRepository<ViewModelFactory, ModelFactory> {
    public Repository(ViewModelApplication a) {
        super(a);
    }

    @Override
    protected ViewModelFactory initViewModelFactory() {
        return new ViewModelFactory(getApplication());
    }

    @Override
    protected ModelFactory initModelFactory() {
        return new ModelFactory(getApplication());
    }
}
