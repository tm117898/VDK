package com.vargo.vdk.example;


import com.vargo.vdk.base.application.ViewModelApplication;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/07 13:57
 */
public class Application extends ViewModelApplication<Repository> {
    @Override
    protected Repository initRepository() {
        return new Repository(this);
    }
}
