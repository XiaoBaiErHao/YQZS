package com.example.trxy.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.trxy.bean.HomeImageBean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class HomeImageAdapter extends BannerAdapter<HomeImageBean, ImageHolder> {

    public HomeImageAdapter(List<HomeImageBean> mDatas) {
        super(mDatas);
    }

    //更新数据
    public void updateData(List<HomeImageBean> data) {
        mDatas.clear();
        mDatas.addAll(data);
        notifyDataSetChanged();
    }


    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, HomeImageBean data, int position, int size) {
        holder.imageView.setImageResource(data.imageRes);
    }
}
