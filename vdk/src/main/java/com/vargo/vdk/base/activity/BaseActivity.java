package com.vargo.vdk.base.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.vargo.vdk.base.fragment.BaseFragment;
import com.vargo.vdk.base.fragment.FragmentHelper;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by shanghaolongteng on 2016/7/14.
 */
public abstract class BaseActivity extends FragmentActivity {
    public static final int CONTENT_VIEW_LAYOUT_INVALID_ID = 0;

    protected Unbinder mButterKnife;
    private FragmentHelper mFragmentHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();
        mButterKnife = ButterKnife.bind(this);
        mFragmentHelper = new FragmentHelper(getSupportFragmentManager());

        setupView();
    }

    /**
     * 设置Activity的ContentView
     */
    private void setContentView() {
        do {
            int id = getContentViewId();
            if (id > CONTENT_VIEW_LAYOUT_INVALID_ID) {
                setContentView(id);
                break;
            }

            View view = getContentView();
            if (view != null) {
                setContentView(view);
                break;
            }
        } while (false);
    }

    /**
     * 获取Activity布局Id
     *
     * @return layoutId
     */
    public abstract int getContentViewId();

    /**
     * 当{@link #getContentViewId()}返回{@link #CONTENT_VIEW_LAYOUT_INVALID_ID}时，
     * 可重写此方法返回View。
     *
     * @return ContentView
     */
    public View getContentView() {
        return null;
    }

    /**
     * 处理View相关操作，如View.setOnClickLister() or AdapterView.setAdapter() or ...
     */
    public void setupView() {
    }

    @Override
    protected void onDestroy() {
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
        mFragmentHelper.replaceFragment(contentLayoutId, fragment, false);
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

    /**
     * 显示Toast
     *
     * @param message 要显示字符
     */
    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示Toast
     *
     * @param messageId 要显示字符id
     */
    protected void showToast(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }
}
