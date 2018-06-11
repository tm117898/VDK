package com.vargo.vdk.example;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vargo.vdk.base.activity.ViewModelActivity;
import com.vargo.vdk.base.viewmodel.BaseViewModel;
import com.vargo.vdk.example.viewmodel.ExampleBaseViewModel;
import com.vargo.vdk.example.viewmodel.RxViewModel;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends ViewModelActivity<Entity, ExampleBaseViewModel> {

    @BindView(R.id.url_tv)
    TextView mUrlTv;
    @BindView(R.id.load_btn)
    Button mLoadBtn;
    @BindView(R.id.show_iv)
    ImageView mShowIv;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<? extends BaseViewModel> getViewModelClass() {
//        return LegacyViewModel.class;
        return RxViewModel.class;
    }

    @Override
    public void onChanged(@Nullable Entity e) {
        if (e != null && e.isSuccess()) {
            Toast.makeText(this, "download success!!!", Toast.LENGTH_SHORT).show();

            ViewGroup.LayoutParams lp = mShowIv.getLayoutParams();
            lp.width = e.getWidth();
            lp.height = e.getHeight();
            mShowIv.setLayoutParams(lp);

            mShowIv.setImageURI(Uri.fromFile(new File(e.getPath())));
        } else {
            Toast.makeText(this, "download failed!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.load_btn)
    public void onViewClicked() {
        ExampleBaseViewModel vm = getViewModel();
        vm.download();
    }
}
