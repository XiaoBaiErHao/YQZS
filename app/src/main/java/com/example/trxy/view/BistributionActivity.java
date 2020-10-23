package com.example.trxy.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trxy.MyApplication;
import com.example.trxy.R;
import com.example.trxy.adapter.BistributionAdapter;
import com.example.trxy.adapter.EpidemicBistributionAdapter;
import com.example.trxy.utils.CheckPermissionsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BistributionActivity extends CheckPermissionsActivity {

    @BindView(R.id.head_back)
    ImageView mHeadBack;
    @BindView(R.id.head_title)
    TextView mHeadTitle;
    @BindView(R.id.bistribution_recyclerView)
    RecyclerView mBistributionRecyclerView;

    private BistributionAdapter bistributionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bistribution);
        ButterKnife.bind(this);

        initDate();
    }

    private void initDate() {
        mHeadTitle.setText("城市详情");
        bistributionsAdapter = new BistributionAdapter();
        mBistributionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBistributionRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mBistributionRecyclerView.setAdapter(bistributionsAdapter);

        bistributionsAdapter.replaceData(MyApplication.getAnEntitySet().getCities());

        bistributionsAdapter.openLoadAnimation();

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
