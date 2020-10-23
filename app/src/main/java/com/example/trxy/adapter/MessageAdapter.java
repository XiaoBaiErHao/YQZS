package com.example.trxy.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;

import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.bean.MessageBean;
import com.example.trxy.utils.DynamicTimeFormat;
import com.example.trxy.utils.FileUtilser;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.view.ChatActivity;
import com.example.trxy.view.QQBrowserPracticeActivity;

import java.util.Collection;

public class MessageAdapter extends BaseRecyclerAdapter<MessageBean>{
    DynamicTimeFormat format = new DynamicTimeFormat();

    public MessageAdapter() {
        super(R.layout.item_practice_instant);
    }

    @Override
    protected void onBindViewHolder(SmartViewHolder holder, MessageBean message, int index) {
        onItemBindingTime(holder, message, index);
        if (message.getUser() == null) {
            onItemBindingSystem(holder, message);
        } else if (message.getUser().isMe()) {
            onItemBindingMine(holder, message);
        } else {
            onItemBindingOther(holder, message);
        }
    }

    /**
     * 展示对方的消息
     */
    private void onItemBindingOther(SmartViewHolder holder, MessageBean message) {
        holder.gone(R.id.chatting_right);
        holder.gone(R.id.chatting_tv_sysmsg);
        holder.visible(R.id.chatting_left);

        holder.image(R.id.chatting_liv_avatar, message.getUser().getAvatarId());


        if (message.getImage() == 0) {
            holder.gone(R.id.chatting_liv_img);

            if (message.getNewsurl() != null){

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent initlder = new Intent(v.getContext(), QQBrowserPracticeActivity.class);
                        initlder.putExtra(QQBrowserPracticeActivity.WEBURL_DETAILS,message.getNewsurl());
                        initlder.putExtra(QQBrowserPracticeActivity.MENUNAME_DETAILS,"新闻");
                        v.getContext().startActivity(initlder);
                    }
                });

                String newsurl = message.getMessage() + "\n\n"
                        + "查看详情\n" + message.getNewsurl();
                holder.text(R.id.chatting_ltv_txt,  newsurl).visible(R.id.chatting_ltv_txt);

            }else if (message.getImgurl() != null){

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent initlder = new Intent(v.getContext(), QQBrowserPracticeActivity.class);
                        initlder.putExtra(QQBrowserPracticeActivity.WEBURL_DETAILS,message.getImgurl());
                        initlder.putExtra(QQBrowserPracticeActivity.MENUNAME_DETAILS,"图片");
                        v.getContext().startActivity(initlder);
                    }
                });

                String imgurl = message.getMessage() + "\n\n"
                        + "查看详情\n" + message.getImgurl();
                holder.text(R.id.chatting_ltv_txt, imgurl).visible(R.id.chatting_ltv_txt);

            }else {
                holder.text(R.id.chatting_ltv_txt, message.getMessage()).visible(R.id.chatting_ltv_txt);
            }

        } else {
            holder.gone(R.id.chatting_ltv_txt);
            holder.image(R.id.chatting_liv_img, message.getImage()).visible(R.id.chatting_liv_img);
        }

    }


    /**
     * 展示自己的消息
     */
    private void onItemBindingMine(SmartViewHolder holder, MessageBean message) {
        holder.gone(R.id.chatting_left);
        holder.gone(R.id.chatting_tv_sysmsg);
        holder.visible(R.id.chatting_right);

        if (MyApplication.getAnEntitySet().getUserInfoBean().getUserHeadUrl() != null){
            holder.setImage(R.id.chatting_riv_avatar, FileUtilser.stringtoBitmap(MyApplication.getAnEntitySet().getUserInfoBean().getUserHeadUrl()));
        }else {
            holder.image(R.id.chatting_riv_avatar, message.getUser().getAvatarId());
        }

        if (message.getImage() == 0) {
            holder.gone(R.id.chatting_riv_img);
            holder.text(R.id.chatting_rtv_txt, message.getMessage()).visible(R.id.chatting_rtv_txt);
        } else {
            holder.gone(R.id.chatting_rtv_txt);
            holder.image(R.id.chatting_riv_img, message.getImage()).visible(R.id.chatting_riv_img);
        }
    }

    /**
     * 展示系统消息
     */
    private void onItemBindingSystem(SmartViewHolder holder, MessageBean message) {
        holder.gone(R.id.chatting_left);
        holder.gone(R.id.chatting_right);
        holder.gone(R.id.chatting_tv_sendtime);
        holder.visible(R.id.chatting_tv_sysmsg).text(R.id.chatting_tv_sysmsg, message.getMessage());
    }


    /**
     * 展示时间
     */
    private void onItemBindingTime(SmartViewHolder holder, MessageBean model, int index) {
        MessageBean prev = null;
        if (index > 0) {
            prev = get(index - 1);
            if (prev.getUser() == null) {
                if (index > 1) {
                    prev = get(index - 2);
                } else {
                    prev = null;
                }
            }
        }
        if (prev != null && (model.getTime().getTime() - prev.getTime().getTime() < 5 * 60 * 1000)) {
            holder.gone(R.id.chatting_tv_sendtime);
        } else {
            holder.visible(R.id.chatting_tv_sendtime);
            holder.text(R.id.chatting_tv_sendtime, format.format(model.getTime()));
        }
    }
}
