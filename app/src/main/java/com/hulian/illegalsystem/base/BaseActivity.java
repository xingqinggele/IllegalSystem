package com.hulian.illegalsystem.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.gyf.barlibrary.ImmersionBar;
import com.hulian.illegalsystem.R;
import com.hulian.illegalsystem.views.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 作者：qgl 时间： 2020/9/14 10:38
 * Describe:基本 activity
 */
public abstract class BaseActivity extends FragmentActivity implements ViewTreeObserver.OnGlobalLayoutListener{
    protected Context mContext;
    public static List<Activity> activitys;
    private ImmersionBar mImmersionBar;//状态栏沉浸
    protected LoadingDialog loadDialog;//加载等待弹窗
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarConfig().init();

        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        mContext = this;
        if (activitys == null) {
            activitys = new ArrayList<Activity>();
        }
        activitys.add(this);
        ButterKnife.bind(this);
        loadDialog = new LoadingDialog(this);
        initView();
        initData();
    }
    //引入布局
    public abstract int getLayoutId();
    //初始化控件
    protected abstract void initView();
    //初始化数据
    protected abstract void initData();
    /**
     * 退出应用
     * @param context
     */
    public void exitApp(Context context) {// 循环结束当前所有Activity
        for (Activity ac : activitys) {
            if (ac != null) {
                ac.finish();
            }
        }
    }
    /**
     * 初始化沉浸式状态栏
     */
    private ImmersionBar statusBarConfig() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.colorAccent)
                .statusBarDarkFont(statusBarDarkFont())    //默认状态栏字体颜色为黑色
                .keyboardEnable(false, WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                        | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
        //必须设置View树布局变化监听，否则软键盘无法顶上去，还有模式必须是SOFT_INPUT_ADJUST_PAN
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        return mImmersionBar;
    }
    /**
     * 获取状态栏字体颜色
     */
    public boolean statusBarDarkFont() {
        //返回false表示白色字体
        return false;
    }
    //Toast
    public void showToast(String text) {
        Toast.makeText(BaseActivity.this, text + "", Toast.LENGTH_SHORT).show();
    }
    //Log
    public void shouLog(String Interface, String text) {
        Log.e(Interface, text + "");
    }
    @Override
    public void onGlobalLayout() {

    }

}
