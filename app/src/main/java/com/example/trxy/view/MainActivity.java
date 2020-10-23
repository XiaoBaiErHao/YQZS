package com.example.trxy.view;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.trxy.R;
import com.example.trxy.utils.CheckPermissionsActivity;
import com.example.trxy.utils.MyActivityManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends CheckPermissionsActivity {
    @BindView(R.id.bnve)
    BottomNavigationViewEx mBnve;
    @BindView(R.id.vp)
    ViewPager mVp;

    private VpAdapter adapter;
    private List<Fragment> fragments;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initEvent();
    }


    private void initData() {
        fragments = new ArrayList<>(3);

        HomePageFragment homeFragment = new HomePageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", getString(R.string.home_page));
        homeFragment.setArguments(bundle);

        ServiceForLifeFragment lifeFragment = new ServiceForLifeFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.lifeserver));
        lifeFragment.setArguments(bundle);

        PersonalCenterFragment meFragment = new PersonalCenterFragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.personal_center));
        meFragment.setArguments(bundle);


        fragments.add(homeFragment);
        fragments.add(lifeFragment);
        fragments.add(meFragment);


        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapter);

        mBnve.setupWithViewPager(mVp);
    }


    private void initEvent() {
        mBnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });

    }


    private static class VpAdapter extends FragmentPagerAdapter {
        private List<Fragment> data;

        public VpAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                MyActivityManager.getInstance().AppExit(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
