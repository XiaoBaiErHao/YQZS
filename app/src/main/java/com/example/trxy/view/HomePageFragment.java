package com.example.trxy.view;

import android.content.Intent;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.adapter.HomeImageAdapter;
import com.example.trxy.adapter.HomeNewsAdapter;
import com.example.trxy.bean.ChatBean;
import com.example.trxy.bean.EpidemicInNationwideBean;
import com.example.trxy.bean.HomeImageBean;
import com.example.trxy.bean.UpdateEpidemicBean;
import com.example.trxy.bean.UserBean;
import com.example.trxy.bean.UserInfo;
import com.example.trxy.bean.UserInfoBean;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.DynamicTimeFormat;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.example.trxy.utils.TimeUtil;
import com.example.trxy.utils.UserUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.util.BannerUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class HomePageFragment extends Fragment implements OnPageChangeListener, View.OnClickListener {
    private Banner mHomeBanner;
    private TextView mHeadTitle;
    private LinearLayout mLineLayoncli;
    private TextView mTvMakeDiagnosis;
    private TextView mTvSuspected;
    private TextView mTvCurative;
    private TextView mTvMortality;
    private TextView mTvMakeDiagnosisIncrease;
    private TextView mTvSuspectedIncrease;
    private TextView mTvCurativeIncrease;
    private TextView mTvMortalityIncrease;
    private LinearLayout mLlGlobal;
    private LinearLayout mLlControl;
    private LinearLayout mLlDistribute;
    private LinearLayout mLlProcess;
    private LinearLayout mLlNucleic;
    private LinearLayout mLlVaccination;
    private LinearLayout mLlConsequences;
    private LinearLayout mLlDevelopment;
    private LinearLayout mLlDynamic;


    private RefreshLayout mHomeRefreshLayout;
    private RecyclerView mHomeRecyclerView;
    private ClassicsHeader mClassicsHeader;
    private Drawable mDrawableProgress;
    private HomeNewsAdapter newsAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_pages_fragment, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
        initUpdate();
        new Handler().postDelayed(new Runnable(){
            public void run(){
                initRequest();
                initRequestTwo();
            }
        },1000);
    }


    private void initView(View view) {
        mHeadTitle = (TextView) view.findViewById(R.id.head_title);
        mHomeRefreshLayout = (RefreshLayout) view.findViewById(R.id.home_refreshLayout);
        mHomeRecyclerView = (RecyclerView) view.findViewById(R.id.home_recyclerView);

        mHeadTitle.setText("首页");
    }

    private void initViewTwo(View view) {
        mHomeBanner = (Banner) view.findViewById(R.id.home_banner);
        mLineLayoncli = (LinearLayout) view.findViewById(R.id.line_layoncli);
        mLineLayoncli.setOnClickListener(this);
        mTvMakeDiagnosis = (TextView) view.findViewById(R.id.tv_make_diagnosis);
        mTvSuspected = (TextView) view.findViewById(R.id.tv_suspected);
        mTvCurative = (TextView) view.findViewById(R.id.tv_curative);
        mTvMortality = (TextView) view.findViewById(R.id.tv_mortality);
        mTvMakeDiagnosisIncrease = (TextView) view.findViewById(R.id.tv_make_diagnosis_increase);
        mTvSuspectedIncrease = (TextView) view.findViewById(R.id.tv_suspected_increase);
        mTvCurativeIncrease = (TextView) view.findViewById(R.id.tv_curative_increase);
        mTvMortalityIncrease = (TextView) view.findViewById(R.id.tv_mortality_increase);

        mLlGlobal = (LinearLayout) view.findViewById(R.id.ll_global);
        mLlGlobal.setOnClickListener(this);
        mLlControl = (LinearLayout) view.findViewById(R.id.ll_control);
        mLlControl.setOnClickListener(this);
        mLlDistribute = (LinearLayout) view.findViewById(R.id.ll_distribute);
        mLlDistribute.setOnClickListener(this);
        mLlProcess = (LinearLayout) view.findViewById(R.id.ll_process);
        mLlProcess.setOnClickListener(this);
        mLlNucleic = (LinearLayout) view.findViewById(R.id.ll_nucleic);
        mLlNucleic.setOnClickListener(this);
        mLlVaccination = (LinearLayout) view.findViewById(R.id.ll_vaccination);
        mLlVaccination.setOnClickListener(this);
        mLlConsequences = (LinearLayout) view.findViewById(R.id.ll_consequences);
        mLlConsequences.setOnClickListener(this);
        mLlDevelopment = (LinearLayout) view.findViewById(R.id.ll_development);
        mLlDevelopment.setOnClickListener(this);
        mLlDynamic = (LinearLayout) view.findViewById(R.id.ll_dynamic);
        mLlDynamic.setOnClickListener(this);

    }

    private void initRequest() {
        EasyHttp.get(NetworkUrl.getEpidemicInformationNationwide())
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
                        EpidemicInNationwideBean epidemicInNationwide = JsonUtil.parseJson(response, EpidemicInNationwideBean.class);
                        if (epidemicInNationwide != null){
                            if (epidemicInNationwide.getData() != null){
                                initDateTwo(epidemicInNationwide);
                            }else {
                                LogUtil.showShort("获取全国疫情数据失败");
                            }
                        }else {
                            LogUtil.e("解析全国疫情数据出错", response);
                        }
                    }
                });

    }


    private void initRequestTwo() {
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
                        UpdateEpidemicBean updateEpidemic = JsonUtil.parseJson(response, UpdateEpidemicBean.class);
                        if (updateEpidemic != null){
                            if (updateEpidemic.getNewslist() != null){
                                for (int m = 0; m < updateEpidemic.getNewslist().size(); m++){
                                    if (updateEpidemic.getNewslist().get(m).getNews() != null){
                                        newsAdapter.replaceData(updateEpidemic.getNewslist().get(m).getNews());
                                    }
                                }

                            }else {
                                LogUtil.showShort("获取疫情动态播报数据失败");
                            }
                        }else {
                            LogUtil.e("解析疫情动态播报出错", response);
                        }
                    }
                });
    }

    private void initDateTwo(EpidemicInNationwideBean epidemicInNationwide) {
        mTvMakeDiagnosis.setText(String.valueOf(epidemicInNationwide.getData().getConfirmedCount()));
        mTvSuspected.setText(String.valueOf(epidemicInNationwide.getData().getSeverecasesCount()));
        mTvCurative.setText(String.valueOf(epidemicInNationwide.getData().getCuredCount()));
        mTvMortality.setText(String.valueOf(epidemicInNationwide.getData().getDeadCount()));

        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        mTvMakeDiagnosisIncrease.setText(time + "号新增" + " " + epidemicInNationwide.getData().getConfirmedAdd());
        mTvSuspectedIncrease.setText(String.valueOf(epidemicInNationwide.getData().getSuspectedAdd()));
        mTvCurativeIncrease.setText(String.valueOf(epidemicInNationwide.getData().getCuredAdd()));
        mTvMortalityIncrease.setText(String.valueOf(epidemicInNationwide.getData().getDeathAdd()));
    }


    private void initUpdate() {
        int delta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
        mClassicsHeader = (ClassicsHeader)mHomeRefreshLayout.getRefreshHeader();
        mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis()-delta));
        mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));
        mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));

        mDrawableProgress = ((ImageView)mClassicsHeader.findViewById(ClassicsHeader.ID_IMAGE_PROGRESS)).getDrawable();
        if (mDrawableProgress instanceof LayerDrawable) {
            mDrawableProgress = ((LayerDrawable) mDrawableProgress).getDrawable(0);
        }

        mHomeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
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

        mHomeRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (newsAdapter.getItemCount() > 10) {
                            Toast.makeText(getContext(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
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


    private void initDate() {
        newsAdapter = new HomeNewsAdapter();
        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //mHomeRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mHomeRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHomeRecyclerView.setAdapter(newsAdapter);

        View header = LayoutInflater.from(getContext()).inflate(R.layout.item_movie_header, mHomeRecyclerView, false);
        initViewTwo(header);

        //设置适配器
        HomeImageAdapter adapter = new HomeImageAdapter(HomeImageBean.getTestData());
        mHomeBanner.setAdapter(adapter);
        //设置指示器
        mHomeBanner.setIndicator(new CircleIndicator(getContext()));
        //设置点击事件
        mHomeBanner.setOnBannerListener((data, position) -> {
            //LogUtil.showShort("第" + position + "张");

        });
        //添加切换监听
        mHomeBanner.addOnPageChangeListener(this);
        //圆角
        mHomeBanner.setBannerRound(BannerUtils.dp2px(5));

        newsAdapter.addHeaderView(header);
        newsAdapter.openLoadAnimation();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        LogUtil.e("当前", "onPageSelected:" + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onStart() {
        super.onStart();
        mHomeBanner.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mHomeBanner.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHomeBanner.destroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.line_layoncli:
                Intent initlder = new Intent(getContext(), NationalEpidemicActivity.class);
                getContext().startActivity(initlder);
                break;
            case R.id.ll_global:
                Intent initlder1 = new Intent(getContext(), GlobalOutbreakActivity.class);
                getContext().startActivity(initlder1);
                break;
            case R.id.ll_control:
                opentUrl("防控知识", "http://app.www.gov.cn/govdata/gov/columns/special_640.html?from=groupmessage&isappinstalled=0");
                break;
            case R.id.ll_distribute:
                Intent initlder2 = new Intent(getContext(), EpidemicBistributionActivity.class);
                getContext().startActivity(initlder2);
                break;
            case R.id.ll_process:
                Intent initlder3 = new Intent(getContext(), RangeQueryActivity.class);
                getContext().startActivity(initlder3);
                break;
            case R.id.ll_nucleic:
                opentUrl("核酸检测", "https://news.qq.com/zt2020/page/nucleic.htm");
                break;
            case R.id.ll_vaccination:
                opentUrl("疫情走势", "https://so.m.sm.cn/s?q=%E7%96%AB%E6%83%85%E8%B5%B0%E5%8A%BF&uc_param_str=dnntnwvepffrgibijbprsvdsmelood&snum=4&by=submit&from=ucframe&uc_sm=1#topic_news_lg/news");
                break;
            case R.id.ll_consequences:
                opentUrl("后果预测", "https://so.m.sm.cn/s?q=%E7%96%AB%E6%83%85%E9%A2%84%E6%B5%8B&uc_param_str=dnntnwvepffrgibijbprsvdsmelood&snum=5&by=submit&from=ucframe&uc_sm=1#topic_news_lg/news");
                break;
            case R.id.ll_development:
                opentUrl("疫苗进展", "https://so.m.sm.cn/s?q=%E5%86%A0%E7%8A%B6%E5%8A%A8%E7%97%85%E6%AF%92%E7%96%AB%E8%8B%97%E6%9C%80%E6%96%B0%E8%BF%9B%E5%B1%95&uc_param_str=dnntnwvepffrgibijbprsvdsmelood&snum=7&by=suggest&from=ucframe&uc_sm=1#topic_news_lg/news");
                break;
            case R.id.ll_dynamic:
                opentUrl("国家动态", "https://so.m.sm.cn/s?uc_param_str=dnntnwvepffrgibijbprsvdsmelood&dn=23999454236-ae330e75&nt=2&nw=WIFI&ve=13.0.0.1080&pf=145&fr=android&gi=bTkwBD1Sh5Vv3YfAFO%2FBiJJ0nvlL7OFzDOVRshcQFeEkyQ%3D%3D&bi=34464&pr=UCMobile&sv=ucrelease1d&ds=bTkwBOBBDB%2F%2B6A%2F9qfsHEchth5IsI8EwevOhb2Sn7UAOuQ%3D%3D&me=AATEWmfPOUmwpvRubHBaZrUS&lo=AAQRAtQtd9XY54gmHPf775eHeM75f0CwjTd43iqSxzKTe9agckcD%2FIjesbpSYtadIlcydDt18WkTzXyUh3Myr%2FU2X7rxhtXugDtyosL4TITn6qCNrRzZrb7IP6vcWPEkPcqosRw9G1GQGPAtwbGgqOqM1W0uUMRK3i4WtYSe53Fj6g%3D%3D&od=AASnFsey%2FWs6%2BcEuSdROr6X2NvWstuMK7QWZ215dQ1RdVCC%2FxTXvX7mIwLwxOIwtbgc%3D&from=wh10331&q=%E5%9B%BD%E5%AE%B6%E7%96%AB%E6%83%85%E9%98%B2%E6%8E%A7%E4%B8%AD%E5%BF%83&by=tuijian&by2=text&uc_sm=1#topic_news_lg/news");
                break;
        }
    }

    private void opentUrl(String title, String url){
        Intent initld = new Intent(getContext(), QQBrowserPracticeActivity.class);
        initld.putExtra(QQBrowserPracticeActivity.WEBURL_DETAILS, url);
        initld.putExtra(QQBrowserPracticeActivity.MENUNAME_DETAILS, title);
        getContext().startActivity(initld);
    }
}
