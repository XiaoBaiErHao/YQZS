package com.example.trxy.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.R;
import com.example.trxy.bean.MemuOptionsBean;
import com.example.trxy.view.ChatActivity;
import com.example.trxy.view.DynamicBroadcastActivity;
import com.example.trxy.view.EpidemicBistributionActivity;
import com.example.trxy.view.GlobalOutbreakActivity;
import com.example.trxy.view.MakeDefiniteDiagnosisActivity;
import com.example.trxy.view.NationalEpidemicActivity;
import com.example.trxy.view.QQBrowserPracticeActivity;
import com.example.trxy.view.RangeQueryActivity;
import com.example.trxy.view.RumorIdentificationActivity;

public class ServiceForLifeAdapter extends BaseQuickAdapter<MemuOptionsBean.AllListBean, BaseViewHolder> {
    public ServiceForLifeAdapter() {
        super(R.layout.service_life_layout);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, MemuOptionsBean.AllListBean item) {
        RecyclerView lifeMenuRecyclerView = (RecyclerView) viewHolder.itemView.findViewById(R.id.life_menu_recyclerView);

        //设置为Listview样式
        int arrayNum = 2;//GridView样式时的列数
        GridLayoutManager layoutManager1 = new GridLayoutManager(mContext, arrayNum);
        lifeMenuRecyclerView.setLayoutManager(layoutManager1);
        //创建Adapter
        ServiceForLifeMenuAdapter menuadapter = new ServiceForLifeMenuAdapter();
        //为RecylcerView设置adapter
        lifeMenuRecyclerView.setAdapter(menuadapter);

        menuadapter.replaceData(item.getMenuList());
        menuadapter.openLoadAnimation();

        viewHolder.setText(R.id.tv_life_menu,item.getModuleName());

    }
}
