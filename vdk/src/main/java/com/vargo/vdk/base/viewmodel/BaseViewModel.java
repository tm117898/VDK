package com.vargo.vdk.base.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.util.ArraySet;

import com.vargo.vdk.base.application.ViewModelApplication;
import com.vargo.vdk.base.livedata.BaseLiveData;

import java.util.Set;

import io.reactivex.disposables.Disposable;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/06 18:05
 */
public abstract class BaseViewModel<T> extends AndroidViewModel implements LifecycleObserver {
    private BaseLiveData<T> mData;
    private Set<Disposable> mCatch = new ArraySet<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
        mData = initLiveData();
    }

    @NonNull
    @Override
    public ViewModelApplication getApplication() {
        return super.getApplication();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCatch.forEach((d) -> {
            if (!d.isDisposed()) {
                d.dispose();
            }
        });
        mCatch.clear();
        mCatch = null;
    }

    protected abstract BaseLiveData<T> initLiveData();

    public BaseLiveData<T> getLiveData() {
        return mData;
    }

    public void register(LifecycleOwner owner, Observer<T> o) {
        owner.getLifecycle().addObserver(this);
        mData.observe(owner, o);
    }

    protected void addDisposableToCatch(Disposable d) {
        mCatch.add(d);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onActivityCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onActivityStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onActivityResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onActivityPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onActivityStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onActivityDestroy() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner, Lifecycle.Event event) {
    }
}
