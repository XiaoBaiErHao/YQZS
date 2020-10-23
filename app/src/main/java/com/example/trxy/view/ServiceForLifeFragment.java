package com.example.trxy.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trxy.R;
import com.example.trxy.adapter.ServiceForLifeAdapter;
import com.example.trxy.bean.MemuOptionsBean;
import com.example.trxy.utils.DynamicTimeFormat;
import com.example.trxy.utils.JsonUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ServiceForLifeFragment extends Fragment {
    private TextView mHeadTitle;
    private RefreshLayout mLifeRefreshLayout;
    private RecyclerView mLifeRecyclerView;
    private ClassicsHeader mClassicsHeader;
    private Drawable mDrawableProgress;
    private ServiceForLifeAdapter lifeAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.service_for_life_fragment, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initDate();
        initUpdate();
    }



    private void initView(View view) {
        mHeadTitle = (TextView) view.findViewById(R.id.head_title);
        mLifeRefreshLayout = (RefreshLayout) view.findViewById(R.id.life_refreshLayout);
        mLifeRecyclerView = (RecyclerView) view.findViewById(R.id.life_recyclerView);

        mHeadTitle.setText("服务");
    }

    private void initUpdate() {
        int delta = new Random().nextInt(7 * 24 * 60 * 60 * 1000);
        mClassicsHeader = (ClassicsHeader)mLifeRefreshLayout.getRefreshHeader();
        mClassicsHeader.setLastUpdateTime(new Date(System.currentTimeMillis()-delta));
        mClassicsHeader.setTimeFormat(new SimpleDateFormat("更新于 MM-dd HH:mm", Locale.CHINA));
        mClassicsHeader.setTimeFormat(new DynamicTimeFormat("更新于 %s"));

        mDrawableProgress = ((ImageView)mClassicsHeader.findViewById(ClassicsHeader.ID_IMAGE_PROGRESS)).getDrawable();
        if (mDrawableProgress instanceof LayerDrawable) {
            mDrawableProgress = ((LayerDrawable) mDrawableProgress).getDrawable(0);
        }

        mLifeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
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

        mLifeRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (lifeAdapter.getItemCount() > 7) {
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
        lifeAdapter = new ServiceForLifeAdapter();
        mLifeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //mHomeRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mLifeRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mLifeRecyclerView.setAdapter(lifeAdapter);


        MemuOptionsBean memuOptions = JsonUtil.parseJson(JsonUtil.readAssert(getContext(),"menu.json"), MemuOptionsBean.class);

        for(int n = 0; n < memuOptions.getAllList().size(); n++){
            lifeAdapter.replaceData(memuOptions.getAllList());
        }

        lifeAdapter.openLoadAnimation();
    }

}
