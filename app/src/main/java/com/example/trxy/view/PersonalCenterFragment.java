package com.example.trxy.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.utils.FileUtilser;
import com.example.trxy.utils.UserUtils;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalCenterFragment extends Fragment implements View.OnClickListener{
    private TextView mHeadTitle;
    private CircleImageView mImgHeader;
    /**
     * 余梅座
     */
    private TextView mTxtUsername;
    /**
     * 开发部
     */
    private SwipeRefreshLayout mSwipeLayout;
    private TextView mTxtAccount;
    private LinearLayout mTecChat;
    private LinearLayout mViewSetting;
    private LinearLayout mViewSettingOut;
    private LinearLayout mPersonalDetails;
    private LinearLayout mMyAdvice;
    private LinearLayout mMyAboutly;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.personal_center_fragment, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEwg();
    }


    private void initView(View view) {
        mHeadTitle = (TextView) view.findViewById(R.id.head_title);
        mSwipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.id_swipe_ly);
        mImgHeader = (CircleImageView) view.findViewById(R.id.img_headerde);
        mTxtUsername = (TextView) view.findViewById(R.id.txt_username);
        mTxtAccount = (TextView) view.findViewById(R.id.txt_account);
        mTecChat = (LinearLayout) view.findViewById(R.id.tec_chat);
        mTecChat.setOnClickListener(this);
        mViewSetting = (LinearLayout) view.findViewById(R.id.view_setting);
        mViewSetting.setOnClickListener(this);
        mViewSettingOut = (LinearLayout) view.findViewById(R.id.view_setting_out);
        mViewSettingOut.setOnClickListener(this);
        mPersonalDetails = (LinearLayout) view.findViewById(R.id.personal_details);
        mPersonalDetails.setOnClickListener(this);
        mMyAdvice = (LinearLayout) view.findViewById(R.id.my_advice);
        mMyAdvice.setOnClickListener(this);
        mMyAboutly = (LinearLayout) view.findViewById(R.id.view_about);
        mMyAboutly.setOnClickListener(this);

        mHeadTitle.setText("个人中心");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.view_setting_out:
                // 注销帐号并销毁当前页面
                UserUtils.getLogout();
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.view_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.tec_chat:
                startActivity(new Intent(getActivity(), EditInfoActivity.class));
                break;
            case R.id.personal_details:
                startActivity(new Intent(getActivity(), PersonalDetailsActivity.class));
                break;
            case R.id.my_advice:
                Intent initer = new Intent(getActivity(), DoThingActivity.class);
                startActivity(initer);
                break;
            case R.id.view_about:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;


        }
    }


    private void initEwg() {
        mSwipeLayout.setColorSchemeColors(getResources().getColor(R.color.NavigationBarColor));
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                initDeta();
                mSwipeLayout.setRefreshing(false);

            }
        });

    }


    private void initDeta() {

        try{

            String headurl = MyApplication.getAnEntitySet().getUserInfoBean().getUserHeadUrl();
            if(headurl == null){
                Glide.with(getContext()).load(R.drawable.ic_usertx)
                        .into(mImgHeader);
            }else{
                /*Glide.with(getContext()).load(headurl)
                        .into(mImgHeader);*/
                mImgHeader.setImageBitmap(FileUtilser.stringtoBitmap(headurl));

            }

            String Name = MyApplication.getAnEntitySet().getUserInfoBean().getUserName();
            if (Name == null){
                mTxtUsername.setText("请完善个人信息");
            }else{
                mTxtUsername.setText(Name);
            }
            String tel = MyApplication.getAnEntitySet().getUserInfoBean().getUserTel();
            if (tel == null){
                mTxtAccount.setText(MyApplication.getAnEntitySet().getUserInfoBean().getUserLoginName());
            }else {
                mTxtAccount.setText(MyApplication.getAnEntitySet().getUserInfoBean().getUserTel());
            }


        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }


    @Override
    public void onResume() {
        super.onResume();
        initDeta();
    }
}
