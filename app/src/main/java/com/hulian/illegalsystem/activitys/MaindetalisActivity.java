package com.hulian.illegalsystem.activitys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hulian.illegalsystem.R;
import com.hulian.illegalsystem.adapter.MainDetelisAdapter;
import com.hulian.illegalsystem.base.BaseActivity;
import com.hulian.illegalsystem.bean.IllegalBean;
import com.hulian.illegalsystem.bean.MainDetelisBean;
import com.hulian.illegalsystem.net.HttpRequest;
import com.hulian.illegalsystem.net.OkHttpException;
import com.hulian.illegalsystem.net.RequestParams;
import com.hulian.illegalsystem.net.ResponseCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：qgl 时间： 2020/9/18 10:45
 * Describe: 违章查询详情列表
 */
public class MaindetalisActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.main_deteli_recycle)
    RecyclerView mainDeteliRecycle;
    @BindView(R.id.main_deteli_swipe)
    SwipeRefreshLayout mainDeteliSwipe;
    @BindView(R.id.iv_back)
    RelativeLayout ivBack;
    private IllegalBean bean;
    private MainDetelisAdapter adapter;
    private List<MainDetelisBean> list = new ArrayList<>();
    private List<MainDetelisBean> mdata = new ArrayList<>();
    private int mCount = 1;

    @Override
    public int getLayoutId() {
        return R.layout.main_detelis_activity;
    }

    @Override
    protected void initView() {
        //接受传过来的值
        bean = (IllegalBean) getIntent().getSerializableExtra("bean");
        mainDeteliSwipe.setOnRefreshListener(this);
        adapter = new MainDetelisAdapter(mdata);
        adapter.openLoadAnimation();
        adapter.setEnableLoadMore(true);
        adapter.setOnLoadMoreListener(this, mainDeteliRecycle);
        adapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.main_detelis_recycle_item, null));
        mainDeteliRecycle.setLayoutManager(new LinearLayoutManager(this));
        mainDeteliRecycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });


    }

    @Override
    protected void initData() {
        mainDeteliSwipe.setRefreshing(false);
        for (int i = 1; i < 11; i++) {
            MainDetelisBean mainDetelisBean = new MainDetelisBean();
            mainDetelisBean.setId("第" + i + "个");
            list.add(mainDetelisBean);
        }
        mdata.addAll(list);
        adapter.loadMoreEnd();
        adapter.notifyDataSetChanged();
    }

    public void subMit() {
        RequestParams params = new RequestParams();
        // 密钥
        params.put("appkey", bean.getAppkey());
        //车牌前缀
        params.put("lsprefix", bean.getLsprefix());
        //车牌剩余部分
        params.put("lsnum", bean.getLsnum());
        //车架号
        params.put("frameno", bean.getFrameno());
        //发动机号
        params.put("engineno", bean.getEngineno());
        //车辆类型
        params.put("lstype", bean.getLstype());
        HttpRequest.getCar_illegal(params, new ResponseCallback() {
            @Override
            public void onSuccess(Object responseObj) {

            }

            @Override
            public void onFailure(OkHttpException failuer) {
                showToast("服务器错误！");
            }
        });
    }

    @Override
    public void onRefresh() {
        mainDeteliSwipe.setRefreshing(true);
        setRefresh();
        initData();
    }

    @Override
    public void onLoadMoreRequested() {
        mCount = mCount + 1;
        initData();
    }

    private void setRefresh() {
        mdata.clear();
        mCount = 1;
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
