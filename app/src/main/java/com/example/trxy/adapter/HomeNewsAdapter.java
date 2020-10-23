package com.example.trxy.adapter;

import android.content.Intent;
import android.graphics.Movie;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.R;
import com.example.trxy.bean.UpdateEpidemicBean;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.utils.TimeUtil;
import com.example.trxy.view.QQBrowserPracticeActivity;

import java.text.ParseException;

public class HomeNewsAdapter extends BaseQuickAdapter<UpdateEpidemicBean.NewslistBean.NewsBean, BaseViewHolder> {

    public HomeNewsAdapter() {
        super(R.layout.home_news_layout);
    }


    @Override
    protected void convert(BaseViewHolder viewHolder, UpdateEpidemicBean.NewslistBean.NewsBean item) {
        try{

            viewHolder.getView(R.id.ll_news).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, QQBrowserPracticeActivity.class);
                    initlder.putExtra(QQBrowserPracticeActivity.WEBURL_DETAILS,item.getSourceUrl());
                    initlder.putExtra(QQBrowserPracticeActivity.MENUNAME_DETAILS,"查看新闻");
                    mContext.startActivity(initlder);
                }
            });

            Glide.with(mContext).load(R.mipmap.ic_launcher)
                    .into((ImageView) viewHolder.getView(R.id.news_avatar));
            String time = "";
            try {
                time = TimeUtil.longToString(item.getPubDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            viewHolder.setText(R.id.news_title, item.getTitle());
            viewHolder.setText(R.id.news_time, time);
            viewHolder.setText(R.id.news_describe, item.getPubDateStr());
            viewHolder.setText(R.id.news_actor, item.getInfoSource());
        }catch (NullPointerException e){
            e.printStackTrace();
            LogUtil.e("新闻数据发生空异常", "请检查数据是否正确");
        }
    }

}
