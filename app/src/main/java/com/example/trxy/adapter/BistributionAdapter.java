package com.example.trxy.adapter;

import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.bean.EpidemicBistributionBean;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.view.BistributionActivity;

public class BistributionAdapter extends BaseQuickAdapter<EpidemicBistributionBean.NewslistBean.CitiesBean, BaseViewHolder> {
    public BistributionAdapter() {
        super(R.layout.epidemic_bistribution_layout);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, EpidemicBistributionBean.NewslistBean.CitiesBean item) {

        viewHolder.getView(R.id.ll_bistribution).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.showShort(item.getCityName());
            }
        });

        viewHolder.setText(R.id.tv_provinceName, item.getCityName());
        viewHolder.setText(R.id.tv_currentConfirmedCount, String.valueOf(item.getCurrentConfirmedCount()));
        viewHolder.setText(R.id.tv_confirmedCount, String.valueOf(item.getConfirmedCount()));
        viewHolder.setText(R.id.tv_suspectedCount, String.valueOf(item.getSuspectedCount()));
        viewHolder.setText(R.id.tv_curedCount, String.valueOf(item.getCuredCount()));
        viewHolder.setText(R.id.tv_deadCount, String.valueOf(item.getDeadCount()));
    }
}
