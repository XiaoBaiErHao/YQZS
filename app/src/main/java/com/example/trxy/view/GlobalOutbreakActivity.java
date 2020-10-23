package com.example.trxy.view;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trxy.R;
import com.example.trxy.adapter.GlobalOutbreakAdapter;
import com.example.trxy.adapter.RangeQueryAdapter;
import com.example.trxy.bean.EpidemicInNationwideBean;
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

//全球疫情
public class GlobalOutbreakActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.global_recyclerView)
    RecyclerView mGlobalRecyclerView;
    private TextView mTvSources;
    private TextView mTvUptimes;
    private TextView mTvGlobal;
    private TextView mTvConfirmed;
    private TextView mTvCured;
    private TextView mTvDead;
    private LinearLayout mLlGlobales;

    private GlobalOutbreakAdapter globalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_outbreak);
        ButterKnife.bind(this);

        initDate();
        initRequest();
    }

    private void initRequest() {
        EasyHttp.get(NetworkUrl.getGlobalEpidemicStatistics())
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
                        GlobalOutbreakBean global = JsonUtil.parseJson(response, GlobalOutbreakBean.class);
                        if (global != null){
                            if (global.getData() != null){
                                initDateTwo(global);
                                if (global.getData().getContinent() != null){
                                    globalAdapter.replaceData(global.getData().getContinent());
                                }else {
                                    LogUtil.showShort("获取全球各州疫情数据失败");
                                }
                            }else {
                                LogUtil.showShort("获取全球疫情数据失败");
                            }
                        }else {
                            LogUtil.e("解析全球疫情数据出错", response);
                        }
                    }
                });

    }

    private void initDateTwo(GlobalOutbreakBean global) {
        mLlGlobales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.showShort(global.getData().getRegion());
            }
        });

        mTvSources.setText(global.getData().getSourceDesc());
        mTvUptimes.setText(global.getData().getUpdateTime());
        mTvGlobal.setText(global.getData().getRegion());
        mTvConfirmed.setText(String.valueOf(global.getData().getConfirmedCount()));
        mTvCured.setText(String.valueOf(global.getData().getCuredCount()));
        mTvDead.setText(String.valueOf(global.getData().getDeadCount()));
    }

    private void initDate() {
        mHeadTitle.setText("全球疫情");
        globalAdapter = new GlobalOutbreakAdapter();
        mGlobalRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mGlobalRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mGlobalRecyclerView.setAdapter(globalAdapter);

        View header = LayoutInflater.from(this).inflate(R.layout.global_outbreak, mGlobalRecyclerView, false);
        initViewTwo(header);

        globalAdapter.addHeaderView(header);
        globalAdapter.openLoadAnimation();

    }

    private void initViewTwo(View view) {
        mTvSources = (TextView) view.findViewById(R.id.tv_sources);
        mTvUptimes = (TextView) view.findViewById(R.id.tv_uptimes);
        mTvGlobal = (TextView) view.findViewById(R.id.tv_global);
        mTvConfirmed = (TextView) view.findViewById(R.id.tv_confirmed);
        mTvCured = (TextView) view.findViewById(R.id.tv_cured);
        mTvDead = (TextView) view.findViewById(R.id.tv_dead);
        mLlGlobales = (LinearLayout) view.findViewById(R.id.ll_globales);

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
