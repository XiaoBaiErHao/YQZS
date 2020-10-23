package com.example.trxy.view;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trxy.R;
import com.example.trxy.adapter.EpidemicBistributionAdapter;
import com.example.trxy.adapter.GlobalOutbreakAdapter;
import com.example.trxy.bean.EpidemicBistributionBean;
import com.example.trxy.bean.GlobalOutbreakBean;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.google.gson.reflect.TypeToken;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//疫情分布
public class EpidemicBistributionActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.epidemic_recyclerView)
    RecyclerView mEpidemicRecyclerView;

    private EpidemicBistributionAdapter bistributionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epidemic_bistribution);
        ButterKnife.bind(this);

        initDate();
        initRequest();
    }

    private void initRequest() {
        EasyHttp.get(NetworkUrl.getEpidemicDistributionMap())
                .readTimeOut(30 * 1000)//局部定义读超时 ,可以不用定义
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)
                .timeStamp(true)
                .headers("apicode", NetworkUrl.getAPICODE())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        LogUtil.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String response) {
                        EpidemicBistributionBean bistribution = JsonUtil.parseJson(response, EpidemicBistributionBean.class);
                        if (bistribution != null){
                            if (bistribution.getNewslist() != null){
                                bistributionAdapter.replaceData(bistribution.getNewslist());
                            }else {
                                LogUtil.showShort("获取疫情分布数据失败");
                            }
                        }else {
                            LogUtil.e("解析疫情分布数据出错", response);
                        }
                    }
                });

    }

    private void initDate() {
        mHeadTitle.setText("国内病例");
        bistributionAdapter = new EpidemicBistributionAdapter();
        mEpidemicRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEpidemicRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mEpidemicRecyclerView.setAdapter(bistributionAdapter);

        bistributionAdapter.openLoadAnimation();

    }

    @OnClick(R.id.head_back)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.head_back:
                finish();
                break;
        }
    }
}
