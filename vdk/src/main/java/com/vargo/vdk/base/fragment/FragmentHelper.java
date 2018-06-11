package com.vargo.vdk.base.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/11 10:30
 */
public class FragmentHelper {
    private FragmentManager mManager;

    public FragmentHelper(FragmentManager mManager) {
        this.mManager = mManager;
    }

    public void destroy() {
        mManager = null;
    }

    public void replaceFragment(int contentLayoutId, BaseFragment fragment) {
        replaceFragment(contentLayoutId, fragment, false);
    }

    public void replaceFragment(int contentLayoutId, BaseFragment fragment, boolean isToBackStack) {
        FragmentManager fm = mManager;
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(contentLayoutId, fragment);
        if (isToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
    }
}
