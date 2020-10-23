package com.example.trxy.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trxy.R;
import com.example.trxy.adapter.DynamicBroadcastAdapter;
import com.example.trxy.adapter.RumorIdentificationAdapter;
import com.example.trxy.bean.RumorIdentificationBean;
import com.example.trxy.bean.UpdateEpidemicBean;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.DynamicTimeFormat;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//动态播报
public class DynamicBroadcastActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.broadcast_recyclerView)
    RecyclerView mBroadcastRecyclerView;
    @BindView(R.id.broadcast_refreshLayout)
    SmartRefreshLayout mBroadcastRefreshLayout;

    private DynamicBroadcastAdapter broadcastAdapter;
    private ClassicsHeader mClassicsHeader;
    private Drawable mDrawableProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_broadcast);
        ButterKnife.bind(this);

        initDate();
        initUpdate();
        initRequest();
    }

    private void initRequest() {
        EasyHttp.get(NetworkUrl.getUpdateEpidemic())
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
                        UpdateEpidemicBean epidemic = JsonUtil.parseJson(response, UpdateEpidemicBean.class);
                        if (epidemic != null){
                            if (epidemic.getNewslist() != null){
                                for (int k = 0; k < epidemic.getNewslist().size(); k++){
                                    if (epidemic.getNewslist().get(k).getNews() != null){
                                        broadcastAdapter.replaceData(epidemic.getNewslist().get(k).getNews());
                                    }
                                }

                            }else {
                                LogUtil.showShort("获取动态播报数据失败");
                            }
                        }else {
                            LogUtil.e("解析动态播报数据出错", response);
                        }
                    }
                });

    }

    private void initDate() {
        mHeadTitle.setText("实时动态");
        broadcastAdapter = new DynamicBroadcastAdapter();
        mBroadcastRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mBroadcastRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mBroadcastRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mBroadcastRecyclerView.setAdapter(broadcastAdapter);

        broadcastAdapter.openLoadAnimation();

    }

    private void initUpdate() {
        int delta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
        mClassicsHeader = (ClassicsHeader)mBroadcastRefreshLayout.getRefreshHeader();
        mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis()-delta));
        mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));
        mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));

        mDrawableProgress = ((ImageView)mClassicsHeader.findViewById(ClassicsHeader.ID_IMAGE_PROGRESS)).getDrawable();
        if (mDrawableProgress instanceof LayerDrawable) {
            mDrawableProgress = ((LayerDrawable) mDrawableProgress).getDrawable(0);
        }

        mBroadcastRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //mAdapter.refresh(initData());
                        refreshLayout.finishRefresh();
                        refreshLayout.resetNoMoreData();//setNoMoreData(false);
                    }
                }, 2000);
            }
        });

        mBroadcastRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (broadcastAdapter.getItemCount() > 10) {
                            Toast.makeText(DynamicBroadcastActivity.this, "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                            refreshLayout.finishLoadMoreWithNoMoreData();//将不会再次触发加载更多事件
                        } else {
                            //newsAdapter.loadMore(initData());
                            refreshLayout.finishLoadMore();
                        }
                    }
                }, 2000);
            }
        });

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
