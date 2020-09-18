package com.hulian.illegalsystem.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.hulian.illegalsystem.R;
import com.hulian.illegalsystem.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：qgl 时间： 2020/9/18 09:06
 * Describe:
 */
public class WelcomeActivity extends BaseActivity {
    @BindView(R.id.main_btn1)
    RelativeLayout mainBtn1;
    @BindView(R.id.main_btn2)
    RelativeLayout mainBtn2;

    @Override
    public int getLayoutId() {
        return R.layout.welcom_activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.main_btn1, R.id.main_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_btn1:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.main_btn2:
                startActivity(new Intent(this,MainActivity1.class));
                break;
        }
    }
}
