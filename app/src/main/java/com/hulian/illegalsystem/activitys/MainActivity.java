package com.hulian.illegalsystem.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.hulian.illegalsystem.R;
import com.hulian.illegalsystem.base.BaseActivity;
import com.hulian.illegalsystem.bean.IllegalBean;
import com.hulian.illegalsystem.net.HttpRequest;
import com.hulian.illegalsystem.net.OkHttpException;
import com.hulian.illegalsystem.net.RequestParams;
import com.hulian.illegalsystem.net.ResponseCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    RelativeLayout ivBack;
    @BindView(R.id.ed_car_prefix)
    EditText edCarPrefix;
    @BindView(R.id.ex_car_number)
    EditText exCarNumber;
    @BindView(R.id.ed_car_chassis)
    EditText edCarChassis;
    @BindView(R.id.ec_car_engine)
    EditText ecCarEngine;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private String appKey = "9c2765c8f6ad29b4";
    private String lstype = "02";

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.iv_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                if (TextUtils.isEmpty(edCarPrefix.getText().toString().trim())) {
                    showToast("请输入车牌前缀");
                    return;
                }
                if (TextUtils.isEmpty(exCarNumber.getText().toString().trim())) {
                    showToast("请输入车牌剩余部分");
                    return;
                }
                if (TextUtils.isEmpty(edCarChassis.getText().toString().trim())) {
                    showToast("请输入车架号");
                    return;
                }
                if (TextUtils.isEmpty(ecCarEngine.getText().toString().trim())) {
                    showToast("请输入发动机号");
                    return;
                }

                IllegalBean bean = new IllegalBean();
                bean.setAppkey(appKey);
                bean.setLsprefix(edCarPrefix.getText().toString().trim());
                bean.setLsnum(exCarNumber.getText().toString().trim());
                bean.setFrameno(edCarChassis.getText().toString().trim());
                bean.setEngineno(ecCarEngine.getText().toString().trim());
                bean.setLstype(lstype);
                Intent intent = new Intent(this, MaindetalisActivity.class);
                intent.putExtra("bean", bean);
                startActivity(intent);
                break;
        }
    }
}
