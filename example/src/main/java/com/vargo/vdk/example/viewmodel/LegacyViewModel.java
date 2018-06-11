package com.vargo.vdk.example.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.vargo.vdk.example.Entity;

import java.io.IOException;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/07 14:05
 */
public class LegacyViewModel extends ExampleBaseViewModel {

    public LegacyViewModel(@NonNull Application application) {
        super(application);
    }

    public void download() {
        new Thread(() -> {
            Entity e;

            try {
                e = getModel().download();
            } catch (IOException e1) {
                e1.printStackTrace();
                e = Entity.getFiledEntity();
            }

            getLiveData().postValue(e);
        }).start();
    }


}
