package com.vargo.vdk.example.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 17:30
 */
public class RxViewModel extends ExampleBaseViewModel {
    public RxViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    public void download() {
        Disposable d = Flowable.fromCallable(() -> getModel().download())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((entity) -> getLiveData().postValue(entity),
                        (e) -> Log.e("shlt", "error", e));

        addDisposableToCatch(d);
    }
}
