package com.example.trxy.view;

import android.graphics.Color;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.example.trxy.R;
import com.example.trxy.adapter.MakeDefiniteDiagnosisAdapter;
import com.example.trxy.adapter.RumorIdentificationAdapter;
import com.example.trxy.bean.JsonBean;
import com.example.trxy.bean.MakeDefiniteDiagnosisBean;
import com.example.trxy.bean.RumorIdentificationBean;
import com.example.trxy.http.NetworkUrl;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.JsonUtil;
import com.example.trxy.utils.LogUtil;
import com.google.gson.reflect.TypeToken;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//确诊地点
public class MakeDefiniteDiagnosisActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.make_recyclerView)
    RecyclerView mMakeRecyclerView;
    @BindView(R.id.ll_make)
    LinearLayout mLlMake;
    @BindView(R.id.tv_province)
    TextView mTvProvince;
    @BindView(R.id.tv_city)
    TextView mTvCity;
    @BindView(R.id.tv_district)
    TextView mTvDistrict;
    @BindView(R.id.tv_free_infection)
    TextView mTvFreeInfection;

    private List<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private MakeDefiniteDiagnosisAdapter makeDiagnosisAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_definite_diagnosis);
        ButterKnife.bind(this);

        initDate();
        initDateTwo();
    }

    private void showPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String opt1tx = options1Items.size() > 0 ?
                        options1Items.get(options1).getPickerViewText() : "";

                String opt2tx = options2Items.size() > 0
                        && options2Items.get(options1).size() > 0 ?
                        options2Items.get(options1).get(options2) : "";

                String opt3tx = options2Items.size() > 0
                        && options3Items.get(options1).size() > 0
                        && options3Items.get(options1).get(options2).size() > 0 ?
                        options3Items.get(options1).get(options2).get(options3) : "";

                String tx = opt1tx + opt2tx + opt3tx;
                mTvProvince.setText(opt1tx);
                mTvCity.setText(opt2tx);
                mTvDistrict.setText(opt3tx);
                initRequest();
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void initRequest() {

        EasyHttp.get(NetworkUrl.getConfirmedLocationNeighborhoodInquiries())
                .readTimeOut(30 * 1000)//局部定义读超时 ,可以不用定义
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)
                .params("province", mTvProvince.getText().toString())
                .params("city", mTvCity.getText().toString())
                .params("district", mTvDistrict.getText().toString())
                .timeStamp(true)
                .headers("apicode", NetworkUrl.getAPICODE())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        LogUtil.showShort(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String response) {
                        MakeDefiniteDiagnosisBean definite = JsonUtil.parseJson(response, MakeDefiniteDiagnosisBean.class);
                        if (definite != null){
                            if (definite.getNewslist() != null){
                                mTvFreeInfection.setVisibility(View.GONE);
                                makeDiagnosisAdapter.replaceData(definite.getNewslist());
                            }else {
                                LogUtil.showShort("获取确诊地点数据失败");
                                mTvFreeInfection.setVisibility(View.VISIBLE);
                                mTvFreeInfection.setText("该地区并无感染病例");
                                initDateTwo();
                            }
                        }else {
                            LogUtil.e("解析确诊地点数据出错", response);
                        }
                    }
                });

    }

    private void initDateTwo() {
        makeDiagnosisAdapter = new MakeDefiniteDiagnosisAdapter();
        mMakeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMakeRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mMakeRecyclerView.setAdapter(makeDiagnosisAdapter);

        makeDiagnosisAdapter.openLoadAnimation();
    }



    private void initDate() {
        mHeadTitle.setText("确诊地点");

        String jsonData = JsonUtil.readAssert(this, "province.json");
        ArrayList<JsonBean> jsonBean = parseData(jsonData);
        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String cityName = jsonBean.get(i).getCityList().get(c).getName();
                cityList.add(cityName);//添加城市
                ArrayList<String> city_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                /*if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    city_AreaList.add("");
                } else {
                    city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }*/
                city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                province_AreaList.add(city_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(cityList);

            /**
             * 添加地区数据
             */
            options3Items.add(province_AreaList);
        }
    }

    public ArrayList<JsonBean> parseData(String result) {
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = JsonUtil.parseJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    @OnClick({R.id.head_back, R.id.ll_make, R.id.tv_free_infection})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.head_back:
                finish();
                break;
            case R.id.ll_make:
                showPickerView();
                break;
            case R.id.tv_free_infection:
                showPickerView();
                break;
        }
    }
}
