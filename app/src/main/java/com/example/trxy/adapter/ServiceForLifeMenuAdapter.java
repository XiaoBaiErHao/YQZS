package com.example.trxy.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

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

public class ServiceForLifeMenuAdapter  extends BaseQuickAdapter<MemuOptionsBean.AllListBean.MenuListBean, BaseViewHolder> {

    public ServiceForLifeMenuAdapter() {
        super(R.layout.service_life_menu_layout);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, MemuOptionsBean.AllListBean.MenuListBean item) {
        viewHolder.setText(R.id.txt_menu_life,item.getName());

        int id = item.getId();
        if (id == 1001){
            Glide.with(mContext).load(R.mipmap.ic_nationwide)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, NationalEpidemicActivity.class);
                    mContext.startActivity(initlder);
                }
            });
        }else if (id == 1002){
            Glide.with(mContext).load(R.mipmap.ic_global)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, GlobalOutbreakActivity.class);
                    mContext.startActivity(initlder);
                }
            });
        }else if (id == 1003){
            Glide.with(mContext).load(R.mipmap.ic_distribute)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, EpidemicBistributionActivity.class);
                    mContext.startActivity(initlder);
                }
            });
        }else if (id == 1004){
            Glide.with(mContext).load(R.mipmap.ic_process)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, RangeQueryActivity.class);
                    mContext.startActivity(initlder);

                }
            });
        }else if (id == 1005){
            Glide.with(mContext).load(R.mipmap.ic_estate)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, MakeDefiniteDiagnosisActivity.class);
                    mContext.startActivity(initlder);
                }
            });
        }else if (id == 1006){
            Glide.with(mContext).load(R.mipmap.ic_identify)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, RumorIdentificationActivity.class);
                    mContext.startActivity(initlder);
                }
            });
        }else if (id == 1007){
            Glide.with(mContext).load(R.mipmap.ic_chat)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, ChatActivity.class);
                    mContext.startActivity(initlder);
                }
            });
        }else if (id == 1008){
            Glide.with(mContext).load(R.mipmap.ic_news)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent initlder = new Intent(mContext, DynamicBroadcastActivity.class);
                    mContext.startActivity(initlder);
                }
            });
        } else if (id == 1009){
            Glide.with(mContext).load(R.mipmap.ic_baidu)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);

        } else if (id == 1010){
            Glide.with(mContext).load(R.mipmap.ic_dinxiang)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        } else if (id == 1011){
            Glide.with(mContext).load(R.mipmap.ic_electric)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1012){
            Glide.with(mContext).load(R.mipmap.ic_water)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1013){
            Glide.with(mContext).load(R.mipmap.ic_celebrity)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1014){
            Glide.with(mContext).load(R.mipmap.ic_letv)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1015){
            Glide.with(mContext).load(R.mipmap.ic_travel)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1016){
            Glide.with(mContext).load(R.mipmap.ic_railway)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1017){
            Glide.with(mContext).load(R.mipmap.ic_gasbill)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1018){
            Glide.with(mContext).load(R.mipmap.ic_budget)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1019){
            Glide.with(mContext).load(R.mipmap.ic_constellation)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1020){
            Glide.with(mContext).load(R.mipmap.ic_music)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1021){
            Glide.with(mContext).load(R.mipmap.ic_academy)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1022){
            Glide.with(mContext).load(R.mipmap.ic_preserve)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1023){
            Glide.with(mContext).load(R.mipmap.ic_telephone)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1024){
            Glide.with(mContext).load(R.mipmap.ic_transportation)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1025){
            Glide.with(mContext).load(R.mipmap.ic_metro)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1026){
            Glide.with(mContext).load(R.mipmap.ic_control_knowledge)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }else if (id == 1027){
            Glide.with(mContext).load(R.mipmap.ic_nucleic_testing)
                    .into((ImageView) viewHolder.getView(R.id.life_menu));

            initDate(viewHolder, item);
        }

    }

    private void initDate(BaseViewHolder viewHolder, MemuOptionsBean.AllListBean.MenuListBean item) {
        viewHolder.getView(R.id.lin_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent initlder = new Intent(mContext, QQBrowserPracticeActivity.class);
                initlder.putExtra(QQBrowserPracticeActivity.WEBURL_DETAILS, item.getUrl());
                initlder.putExtra(QQBrowserPracticeActivity.MENUNAME_DETAILS, item.getName());
                mContext.startActivity(initlder);
            }
        });
    }
}
