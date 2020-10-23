package com.example.trxy.adapter;

import android.content.Intent;
import android.graphics.Movie;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.bean.GlobalOutbreakBean;
import com.example.trxy.bean.UpdateEpidemicBean;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.utils.TimeUtil;
import com.example.trxy.view.AllCountriesActivity;
import com.example.trxy.view.QQBrowserPracticeActivity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class GlobalOutbreakAdapter extends BaseQuickAdapter<GlobalOutbreakBean.DataBean.ContinentBean, BaseViewHolder> {

    public GlobalOutbreakAdapter() {
        super(R.layout.global_outbreak_layout);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, GlobalOutbreakBean.DataBean.ContinentBean item) {

        if (item.getCountry() != null){
            viewHolder.getView(R.id.ll_epidemic).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (item.getCountry().size() == 0){
                        LogUtil.showShort(item.getContinentName());
                    }else {
                        mContext.startActivity(new Intent(mContext,AllCountriesActivity.class));
                        MyApplication.getAnEntitySet().setCountry(item.getCountry());
                    }

                }
            });
        }else {
            LogUtil.e("各国数据为空","");
        }

        if (item.getCountry().size() != 0){
            viewHolder.getView(R.id.img_look_over).setVisibility(View.VISIBLE);
        }


        viewHolder.setText(R.id.tv_provinceName, item.getContinentName());
        viewHolder.setText(R.id.tv_confirmedCount, String.valueOf(item.getConfirmedCount()));
        viewHolder.setText(R.id.tv_curedCount, String.valueOf(item.getCuredCount()));
        viewHolder.setText(R.id.tv_deadCount, String.valueOf(item.getDeadCount()));
    }
}
