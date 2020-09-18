package com.hulian.illegalsystem.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hulian.illegalsystem.R;
import com.hulian.illegalsystem.bean.MainDetelisBean;

import java.util.List;

/**
 * 作者：qgl 时间： 2020/9/18 14:19
 * Describe:
 */
public class MainDetelisAdapter extends BaseQuickAdapter<MainDetelisBean, BaseViewHolder> {

    public MainDetelisAdapter( @Nullable List<MainDetelisBean> data) {
        super(R.layout.main_detelis_recycle_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainDetelisBean item) {
            helper.setText(R.id.item_btn_num,item.getId());
    }


}
