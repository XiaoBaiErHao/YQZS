package com.example.trxy.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.trxy.R;
import com.example.trxy.bean.EpidemicInNationwideBean;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//全国疫情
public class NationalEpidemicActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.tv_source)
    TextView mTvSource;
    @BindView(R.id.tv_uptime)
    TextView mTvUptime;
    @BindView(R.id.tv_definite)
    TextView mTvDefinite;
    @BindView(R.id.tv_suspected)
    TextView mTvSuspected;
    @BindView(R.id.tv_servious)
    TextView mTvServious;
    @BindView(R.id.tv_new_diagnosis)
    TextView mTvNewDiagnosis;
    @BindView(R.id.tv_new_suspected)
    TextView mTvNewSuspected;
    @BindView(R.id.tv_new_severe)
    TextView mTvNewSevere;
    @BindView(R.id.tv_demise)
    TextView mTvDemise;
    @BindView(R.id.tv_healing)
    TextView mTvHealing;
    @BindView(R.id.tv_new_death)
    TextView mTvNewDeath;
    @BindView(R.id.tv_new_cure)
    TextView mTvNewCure;
    @BindView(R.id.tv_hint)
    TextView mTvHint;
    @BindView(R.id.ll_national)
    LinearLayout mLlNational;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_epidemic);
        ButterKnife.bind(this);

        mHeadTitle.setText("国内疫情");

        new Handler().postDelayed(new Runnable(){
            public void run(){
                initRequest();
            }
        },1000);

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
                        EpidemicInNationwideBean epidemic = JsonUtil.parseJson(response, EpidemicInNationwideBean.class);
                        if (epidemic != null){
                            if (epidemic.getData() != null){
                                initDateTwo(epidemic);
                            }else {
                                LogUtil.showShort("获取全国疫情数据失败");
                            }
                        }else {
                            LogUtil.e("解析全国疫情数据出错", response);
                        }
                    }
                });

    }

    private void initDateTwo(EpidemicInNationwideBean epidemic) {
        mTvSource.setText(String.valueOf(epidemic.getData().getSourceDesc()));
        mTvUptime.setText(String.valueOf(epidemic.getData().getUpdateTime()));
        mTvDefinite.setText(String.valueOf(epidemic.getData().getConfirmedCount()));
        mTvSuspected.setText(String.valueOf(epidemic.getData().getSuspectedCount()));
        mTvServious.setText(String.valueOf(epidemic.getData().getSeverecasesCount()));
        mTvNewDiagnosis.setText(String.valueOf(epidemic.getData().getConfirmedAdd()));
        mTvNewSuspected.setText(String.valueOf(epidemic.getData().getSuspectedAdd()));
        mTvNewSevere.setText(String.valueOf(epidemic.getData().getSeverecasesAdd()));
        mTvDemise.setText(String.valueOf(epidemic.getData().getDeadCount()));
        mTvHealing.setText(String.valueOf(epidemic.getData().getCuredCount()));
        mTvNewDeath.setText(String.valueOf(epidemic.getData().getDeathAdd()));
        mTvNewCure.setText(String.valueOf(epidemic.getData().getCuredAdd()));
        mTvHint.setText(epidemic.getData().getDescription());
    }

    @OnClick({R.id.head_back, R.id.ll_national})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.head_back:
                finish();
                break;
            case R.id.ll_national:
                Intent initlder2 = new Intent(this, EpidemicBistributionActivity.class);
                startActivity(initlder2);
                break;
        }
    }
}
