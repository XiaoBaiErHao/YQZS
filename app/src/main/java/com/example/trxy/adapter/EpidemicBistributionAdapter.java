package com.example.trxy.adapter;

import android.content.Intent;
import android.graphics.Movie;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.bean.EpidemicBistributionBean;
import com.example.trxy.bean.GlobalOutbreakBean;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.view.AllCountriesActivity;
import com.example.trxy.view.BistributionActivity;

public class EpidemicBistributionAdapter extends BaseQuickAdapter<EpidemicBistributionBean.NewslistBean, BaseViewHolder> {
    public EpidemicBistributionAdapter() {
        super(R.layout.epidemic_bistribution_layout);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, EpidemicBistributionBean.NewslistBean item) {

        if (item.getCities() != null){
            viewHolder.getView(R.id.ll_bistribution).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item.getCities().size() == 0){
                        LogUtil.showShort(item.getProvinceName());
                    }else {
                        mContext.startActivity(new Intent(mContext, BistributionActivity.class));
                        MyApplication.getAnEntitySet().setCities(item.getCities());
                    }

                }
            });
        }else {
            LogUtil.e("疫情分布城市数据为空","");
        }

        if (item.getCities().size() != 0){
            viewHolder.getView(R.id.img_emidemic_look_over).setVisibility(View.VISIBLE);
        }

        viewHolder.setText(R.id.tv_provinceName, item.getProvinceName());
        viewHolder.setText(R.id.tv_currentConfirmedCount, String.valueOf(item.getCurrentConfirmedCount()));
        viewHolder.setText(R.id.tv_confirmedCount, String.valueOf(item.getConfirmedCount()));
        viewHolder.setText(R.id.tv_suspectedCount, String.valueOf(item.getSuspectedCount()));
        viewHolder.setText(R.id.tv_curedCount, String.valueOf(item.getCuredCount()));
        viewHolder.setText(R.id.tv_deadCount, String.valueOf(item.getDeadCount()));
    }
}
