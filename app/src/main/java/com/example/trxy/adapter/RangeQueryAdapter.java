package com.example.trxy.adapter;

import android.content.Intent;
import android.graphics.Movie;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.R;
import com.example.trxy.bean.RangeQueryBean;
import com.example.trxy.view.QQBrowserPracticeActivity;

public class RangeQueryAdapter extends BaseQuickAdapter<RangeQueryBean.NewslistBean, BaseViewHolder> {
    public RangeQueryAdapter() {
        super(R.layout.range_query_layout);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, RangeQueryBean.NewslistBean item) {
        viewHolder.getView(R.id.ll_range).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent initlder = new Intent(mContext, QQBrowserPracticeActivity.class);
                initlder.putExtra(QQBrowserPracticeActivity.WEBURL_DETAILS,item.getSource());
                initlder.putExtra(QQBrowserPracticeActivity.MENUNAME_DETAILS,"查看详情");
                mContext.startActivity(initlder);
            }
        });

        if(TextUtils.isEmpty(item.getPos_start())){
            viewHolder.setText(R.id.tv_starting_platform, "其他");
        }else {
            viewHolder.setText(R.id.tv_starting_platform, item.getPos_start());
        }
        if(TextUtils.isEmpty(item.getPos_end())){
            viewHolder.setText(R.id.tv_reach, "其他");
        }else {
            viewHolder.setText(R.id.tv_reach, item.getPos_end());
        }

        viewHolder.setText(R.id.tv_timely, item.getDate());
        if (item.getType() == 1){
            viewHolder.setText(R.id.tv_vehicle, "飞机");
        }else if (item.getType() == 2){
            viewHolder.setText(R.id.tv_vehicle, "火车");
        }else if (item.getType() == 3){
            viewHolder.setText(R.id.tv_vehicle, "地铁");
        }else if (item.getType() == 4){
            viewHolder.setText(R.id.tv_vehicle, "汽车");
        }else {
            viewHolder.setText(R.id.tv_vehicle, "其他");
        }

        viewHolder.setText(R.id.tv_grades, item.getNo());
        viewHolder.setText(R.id.tv_source, item.getWho());

    }
}
