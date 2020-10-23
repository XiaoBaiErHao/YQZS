package com.example.trxy.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.adapter.AllCountriesAdapter;
import com.example.trxy.adapter.GlobalOutbreakAdapter;
import com.example.trxy.utils.CheckPermissionsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllCountriesActivity extends CheckPermissionsActivity {
    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.countries_recyclerView)
    RecyclerView mCountriesRecyclerView;

    private AllCountriesAdapter countriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_countries);
        ButterKnife.bind(this);

        initDate();
    }

    private void initDate() {
        mHeadTitle.setText("全球疫情");
        countriesAdapter = new AllCountriesAdapter();
        mCountriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCountriesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCountriesRecyclerView.setAdapter(countriesAdapter);

        countriesAdapter.replaceData(MyApplication.getAnEntitySet().getCountry());

        countriesAdapter.openLoadAnimation();

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
