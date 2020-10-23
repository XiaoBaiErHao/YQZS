package com.example.trxy.adapter;

import android.content.Intent;
import android.graphics.Movie;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.trxy.R;
import com.example.trxy.bean.MakeDefiniteDiagnosisBean;
import com.example.trxy.bean.RumorIdentificationBean;
import com.example.trxy.view.QQBrowserPracticeActivity;

public class MakeDefiniteDiagnosisAdapter extends BaseQuickAdapter<MakeDefiniteDiagnosisBean.NewslistBean, BaseViewHolder> {

    public MakeDefiniteDiagnosisAdapter() {
        super(R.layout.make_definite_layout);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, MakeDefiniteDiagnosisBean.NewslistBean item) {
        viewHolder.setText(R.id.tv_address, item.getAddress());
        viewHolder.setText(R.id.tv_locale, item.getLocale());
        viewHolder.setText(R.id.tv_source, item.getSource());

    }
}
