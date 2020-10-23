package com.example.trxy.bean;


import com.example.trxy.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeImageBean {
    public Integer imageRes;
    public String imageUrl;
    public String title;
    public int viewType;

    public HomeImageBean(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public HomeImageBean(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }

    public static List<HomeImageBean> getTestData() {
        List<HomeImageBean> list = new ArrayList<>();
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_1, null, 1));
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_2, null, 2));
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_3, null, 3));
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_4, null, 1));
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_5, null, 1));
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_6, null, 5));
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_7, null, 4));
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_8, null, 6));
        list.add(new HomeImageBean(R.mipmap.ic_outbreak_pictures_9, null, 7));
        return list;
    }

}
