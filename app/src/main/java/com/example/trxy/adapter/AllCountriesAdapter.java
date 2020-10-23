package com.example.trxy.adapter;

import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.bean.GlobalOutbreakBean;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.view.AllCountriesActivity;

public class AllCountriesAdapter extends BaseQuickAdapter<GlobalOutbreakBean.DataBean.ContinentBean.CountryBean, BaseViewHolder> {

    public AllCountriesAdapter() {
        super(R.layout.global_outbreak_layout);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, GlobalOutbreakBean.DataBean.ContinentBean.CountryBean item) {

        viewHolder.getView(R.id.ll_epidemic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.showShort(item.getProvinceName());
            }
        });

        viewHolder.setText(R.id.tv_provinceName, item.getProvinceName());
        viewHolder.setText(R.id.tv_confirmedCount, String.valueOf(item.getConfirmedCount()));
        viewHolder.setText(R.id.tv_curedCount, String.valueOf(item.getCuredCount()));
        viewHolder.setText(R.id.tv_deadCount, String.valueOf(item.getDeadCount()));
    }
}
