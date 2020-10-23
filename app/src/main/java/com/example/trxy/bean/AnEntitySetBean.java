package com.example.trxy.bean;

import java.util.List;

public class AnEntitySetBean {
    private UserInfoBean userInfoBean;
    private List<GlobalOutbreakBean.DataBean.ContinentBean.CountryBean> country;
    private List<EpidemicBistributionBean.NewslistBean.CitiesBean> cities;
    private ChatBean chatBean;

    public UserInfoBean getUserInfoBean() {
        return userInfoBean;
    }

    public void setUserInfoBean(UserInfoBean userInfoBean) {
        this.userInfoBean = userInfoBean;
    }

    public List<GlobalOutbreakBean.DataBean.ContinentBean.CountryBean> getCountry() {
        return country;
    }

    public void setCountry(List<GlobalOutbreakBean.DataBean.ContinentBean.CountryBean> country) {
        this.country = country;
    }

    public List<EpidemicBistributionBean.NewslistBean.CitiesBean> getCities() {
        return cities;
    }

    public void setCities(List<EpidemicBistributionBean.NewslistBean.CitiesBean> cities) {
        this.cities = cities;
    }

    public ChatBean getChatBean() {
        return chatBean;
    }

    public void setChatBean(ChatBean chatBean) {
        this.chatBean = chatBean;
    }

}
