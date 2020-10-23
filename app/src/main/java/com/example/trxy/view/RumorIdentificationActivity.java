package com.example.trxy.view;

import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.trxy.R;
import com.example.trxy.adapter.BaseRecyclerAdapter;
import com.example.trxy.adapter.HomeNewsAdapter;
import com.example.trxy.adapter.RumorIdentificationAdapter;
import com.example.trxy.adapter.SmartViewHolder;
import com.example.trxy.bean.EpidemicInNationwideBean;
import com.example.trxy.bean.RumorIdentificationBean;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.DynamicTimeFormat;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.layout.simple_list_item_2;

//谣言鉴别
public class RumorIdentificationActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.rumor_recyclerView)
    RecyclerView mRumorRecyclerView;
    @BindView(R.id.rumor_refreshLayout)
    SmartRefreshLayout mRumorRefreshLayout;

    private ClassicsHeader mClassicsHeader;
    private Drawable mDrawableProgress;
    private RumorIdentificationAdapter identificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rumor_identification);
        ButterKnife.bind(this);
        
        initDate();
        initUpdate();
        initRequest();
    }

    private void initRequest() {
        EasyHttp.get(NetworkUrl.getTheRumorIdentification())
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
                        RumorIdentificationBean identification = JsonUtil.parseJson(response, RumorIdentificationBean.class);
                        if (identification != null){
                            if (identification.getNewslist() != null){
                                identificationAdapter.replaceData(identification.getNewslist());
                            }else {
                                LogUtil.showShort("获取谣言鉴别数据失败");
                            }
                        }else {
                            LogUtil.e("解析谣言鉴别数据出错", response);
                        }
                    }
                });

    }

    private void initDate() {
        mHeadTitle.setText("谣言鉴别");
        identificationAdapter = new RumorIdentificationAdapter();
        //设置横向滚动LinearLayoutManager.HORIZONTAL
        mRumorRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRumorRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRumorRecyclerView.setAdapter(identificationAdapter);

        //快速滑动并最终定位到居中位置
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRumorRecyclerView);

        identificationAdapter.openLoadAnimation();

    }


    private void initUpdate() {
        int delta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
        mClassicsHeader = (ClassicsHeader)mRumorRefreshLayout.getRefreshHeader();
        mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis()-delta));
        mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));
        mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));

        mDrawableProgress = ((ImageView)mClassicsHeader.findViewById(ClassicsHeader.ID_IMAGE_PROGRESS)).getDrawable();
        if (mDrawableProgress instanceof LayerDrawable) {
            mDrawableProgress = ((LayerDrawable) mDrawableProgress).getDrawable(0);
        }

        mRumorRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
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

        mRumorRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (identificationAdapter.getItemCount() > 10) {
                            Toast.makeText(RumorIdentificationActivity.this, "数据全部加载完毕", Toast.LENGTH_SHORT).show();
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
