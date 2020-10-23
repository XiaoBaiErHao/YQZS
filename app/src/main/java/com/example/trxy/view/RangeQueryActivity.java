package com.example.trxy.view;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.trxy.R;
import com.example.trxy.adapter.DynamicBroadcastAdapter;
import com.example.trxy.adapter.RangeQueryAdapter;
import com.example.trxy.bean.EpidemicInNationwideBean;
import com.example.trxy.bean.RangeQueryBean;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//同程查询
public class RangeQueryActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.range_recyclerView)
    RecyclerView mRangeRecyclerView;
    private EditText mEdtQuerySite;
    private RelativeLayout mRlTransportation;
    private TextView mTvTransportation;
    private EditText mEdtDeparture;
    private RelativeLayout mRlOptionDate;
    private TextView mTvOptionDate;
    private Button mBtQuery;

    private RangeQueryAdapter rangeAdapter;
    private TimePickerView pvTime;
    private OptionsPickerView pvOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_query);
        ButterKnife.bind(this);

        initDate();
        initRequest();
        initTimePicker();
    }

    private void initTimePicker() {//Dialog 模式下，在底部弹出

        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                mTvOptionDate.setText(getTime(date));
                Log.i("pvTime", "onTimeSelect");

            }
        }).setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                }).setType(new boolean[]{true, true, true, false, false, false})//年月日时分秒 的显示与否，不设置则默认全部显示
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .addOnCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("pvTime", "onCancelClickListener");
                    }
                }).build();

        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
                dialogWindow.setDimAmount(0.1f);
            }
        }



        List<String> strtype = new ArrayList<>();
        strtype.add("飞机");
        strtype.add("火车");
        strtype.add("地铁");
        strtype.add("汽车");

        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                mTvTransportation.setText(strtype.get(options1));
            }
        })
                //这几个值没需求的可以不要
                .setDividerColor(Color.BLACK)
                //设置选中项文字颜色
                .setTextColorCenter(Color.BLACK)
                .setContentTextSize(20)
                // default is true
                .setOutSideCancelable(false)
                .build();//这个不能丢

        //一级选择器
        pvOptions.setPicker(strtype);

    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    private void initRequest() {
        String querySite = mEdtQuerySite.getText().toString();
        String departure = mEdtDeparture.getText().toString();
        String transportation = mTvTransportation.getText().toString();
        String optionDate = mTvOptionDate.getText().toString();
        String typely = "";

        if (transportation.equals("飞机")){
            typely = "1";
        }else if (transportation.equals("火车")){
            typely = "2";
        }else if (transportation.equals("地铁")){
            typely = "3";
        }else if (transportation.equals("汽车")){
            typely = "4";
        }

        LogUtil.e("00",querySite +departure+transportation+optionDate+typely);

        EasyHttp.get(NetworkUrl.getPneumoniaConcurrentQuery())
                .readTimeOut(30 * 1000)//局部定义读超时 ,可以不用定义
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)
                .params("arrive",querySite)
                .params("date",optionDate)
                .params("no",departure)
                .params("num","10")
                .params("page","1")
                .params("type",typely)
                .timeStamp(true)
                .headers("apicode", NetworkUrl.getAPICODE())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        LogUtil.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String response) {
                        LogUtil.e("000",response);
                        RangeQueryBean rangeQuery = JsonUtil.parseJson(response, RangeQueryBean.class);
                        if (rangeQuery != null){
                            if (rangeQuery.getNewslist() != null){
                                rangeAdapter.replaceData(rangeQuery.getNewslist());
                            }else {
                                LogUtil.showShort("获取肺炎同程数据失败");
                            }
                        }else {
                            LogUtil.e("解析肺炎同程数据出错", response);
                        }
                    }
                });

    }

    private void initDate() {
        mHeadTitle.setText("同程查询");

        rangeAdapter = new RangeQueryAdapter();
        mRangeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mRangeRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRangeRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRangeRecyclerView.setAdapter(rangeAdapter);

        View header = LayoutInflater.from(this).inflate(R.layout.range_layout, mRangeRecyclerView, false);
        initDateTwo(header);

        rangeAdapter.addHeaderView(header);
        rangeAdapter.openLoadAnimation();

    }

    private void initDateTwo(View view) {
        mEdtQuerySite = (EditText) view.findViewById(R.id.edt_query_site);
        mRlTransportation = (RelativeLayout) view.findViewById(R.id.rl_transportation);
        mTvTransportation = (TextView) view.findViewById(R.id.tv_transportation);
        mEdtDeparture = (EditText) view.findViewById(R.id.edt_departure);
        mRlOptionDate = (RelativeLayout) view.findViewById(R.id.rl_option_date);
        mTvOptionDate = (TextView) view.findViewById(R.id.tv_option_date);
        mBtQuery = (Button) view.findViewById(R.id.bt_query);

        mRlTransportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvOptions.show(v);
            }
        });
        mRlOptionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show(v);
            }
        });
        mBtQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initRequest();
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
