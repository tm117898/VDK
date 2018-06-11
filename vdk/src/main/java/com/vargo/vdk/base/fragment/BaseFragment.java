package com.vargo.vdk.base.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Cesc Shang on 2017/7/17.
 */

public abstract class BaseFragment extends Fragment {
    public static final int CONTENT_VIEW_LAYOUT_INVALID_ID = 0;

    protected Unbinder mButterKnife;
    private FragmentHelper mFragmentHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = setContentView(inflater, container);
        mButterKnife = ButterKnife.bind(this, view);
        mFragmentHelper = new FragmentHelper(getFragmentManager());

        setupView(view);
        return view;
    }

    /**
     * 设置Activity的ContentView
     *
     * @param inflater  LayoutInflater
     * @param container 容器
     * @return ContentView
     */
    private View setContentView(LayoutInflater inflater, ViewGroup container) {
        View contentView = null;
        do {
            int id = getContentViewId();
            if (id > CONTENT_VIEW_LAYOUT_INVALID_ID) {
                contentView = inflater.inflate(id, container, false);
                break;
            }

            View view = getContentView();
            if (view != null) {
                contentView = view;
                break;
            }
        } while (false);

        return contentView;
    }

    /**
     * 获取Activity布局Id
     *
     * @return layoutId
     */
    protected abstract int getContentViewId();

    /**
     * 当{@link #getContentViewId()}返回{@link #CONTENT_VIEW_LAYOUT_INVALID_ID}时，
     * 可重写此方法返回View。
     *
     * @return ContentView
     */
    protected View getContentView() {
        return null;
    }

    /**
     * 处理View相关操作，如View.setOnClickLister() or AdapterView.setAdapter() or ...
     *
     * @param rootView Fragment根布局
     */
    protected void setupView(View rootView) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mButterKnife.unbind();
        mFragmentHelper.destroy();
    }

    /**
     * 替换当前显示Fragment
     *
     * @param contentLayoutId Fragment的容器Id
     * @param fragment        要显示的Fragment
     */
    public void replaceFragment(int contentLayoutId, BaseFragment fragment) {
        mFragmentHelper.replaceFragment(contentLayoutId, fragment);
    }

    /**
     * 替换当前显示Fragment
     *
     * @param contentLayoutId Fragment的容器Id
     * @param fragment        要显示的Fragment
     * @param isToBackStack   是都将Fragment加入回退栈
     */
    public void replaceFragment(int contentLayoutId, BaseFragment fragment, boolean isToBackStack) {
        mFragmentHelper.replaceFragment(contentLayoutId, fragment, isToBackStack);
    }
}
