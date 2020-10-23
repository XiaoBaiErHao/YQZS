package com.example.trxy.adapter;

import android.content.Intent;
import android.graphics.Movie;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.R;
import com.example.trxy.bean.MemuOptionsBean;
import com.example.trxy.bean.RumorIdentificationBean;
import com.example.trxy.view.QQBrowserPracticeActivity;

import java.util.Collection;

public class RumorIdentificationAdapter extends BaseQuickAdapter<RumorIdentificationBean.NewslistBean, BaseViewHolder>{


    public RumorIdentificationAdapter() {
        super(R.layout.rumor_identification_layout);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, RumorIdentificationBean.NewslistBean item) {

        if (item.getMarkstyle().equals("fake")){
            viewHolder.setTextColor(R.id.rumor_fiction, mContext.getResources().getColor(R.color.orange_red));
        }else if (item.getMarkstyle().equals("doubt")){
            viewHolder.setTextColor(R.id.rumor_fiction, mContext.getResources().getColor(R.color.orange));
        }else if (item.getMarkstyle().equals("true")){
            viewHolder.setTextColor(R.id.rumor_fiction, mContext.getResources().getColor(R.color.cyan));
        }else {
            viewHolder.setTextColor(R.id.rumor_fiction, mContext.getResources().getColor(R.color.deashing));
        }

        viewHolder.setText(R.id.rumor_title, item.getTitle());
        viewHolder.setText(R.id.rumor_time, item.getDate());
        viewHolder.setText(R.id.rumor_describe, item.getDesc());
        viewHolder.setText(R.id.rumor_actor, item.getAuthor());
        viewHolder.setText(R.id.rumor_fiction, item.getExplain());

        Glide.with(mContext).load(item.getImgsrc())
                .into((ImageView)viewHolder.getView(R.id.img_url));

    }
}
