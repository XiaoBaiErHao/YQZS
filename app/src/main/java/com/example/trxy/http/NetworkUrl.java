package com.example.trxy.http;

public class NetworkUrl {
    //新冠肺炎实时数据KEY
    public static final String APICODE = "705def8a73644ced9991113a62a20cb5";

    public static String getAPICODE() {
        return APICODE;
    }

    //服务器地址
    public static final String serverAddress = "https://api.yonyoucloud.com";

    public static String getServerAddress() {
        return serverAddress;
    }

    //IP服务器地址
    public static final String serverIP = "http://192.168.6.109:8080";

    public static String getServerIP() {
        return serverIP;
    }

    //注册
    public static final String userRegister = getServerIP() + "/YQZS/member/userRegister";

    public static String getUserRegister() {
        return userRegister;
    }

    //登录
    public static final String userLogin = getServerIP() + "/YQZS/member/userLogin";

    public static String getUserLogin() {
        return userLogin;
    }

    //修改用户信息
    public static final String userInformation = getServerIP() + "/YQZS/member/userInformation";

    public static String getUserInformation() {
        return userInformation;
    }

    //修改用户密码
    public static final String userPassword = getServerIP() + "/YQZS/member/userPassword";

    public static String getUserPassword() {
        return userPassword;
    }

    //用户ID查信息
    public static final String userInfo = getServerIP() + "/YQZS/member/getUserInfo";

    public static String getUserInfo() {
        return userInfo;
    }

    //全国疫情统计
    public static final String epidemicInformationNationwide = getServerAddress() + "/apis/dst/ncov/country";

    public static String getEpidemicInformationNationwide() {
        return epidemicInformationNationwide;
    }

    //全球疫情统计
    public static final String globalEpidemicStatistics = getServerAddress() + "/apis/dst/ncov/wholeworld";

    public static String getGlobalEpidemicStatistics() {
        return globalEpidemicStatistics;
    }

    //疫情分布地图
    public static final String epidemicDistributionMap = getServerAddress() + "/apis/dst/ncov/spreadQuery";

    public static String getEpidemicDistributionMap() {
        return epidemicDistributionMap;
    }

    //肺炎同程查询
    public static final String pneumoniaConcurrentQuery = getServerAddress() + "/apis/dst/ncov/tripQuery";

    public static String getPneumoniaConcurrentQuery() {
        return pneumoniaConcurrentQuery;
    }

    //确诊地点和小区查询
    public static final String confirmedLocationNeighborhoodInquiries = getServerAddress() + "/apis/dst/ncov/fynearby";

    public static String getConfirmedLocationNeighborhoodInquiries() {
        return confirmedLocationNeighborhoodInquiries;
    }

    //谣言鉴别
    public static final String theRumorIdentification = getServerAddress() + "/apis/dst/ncov/identifyRumor";

    public static String getTheRumorIdentification() {
        return theRumorIdentification;
    }

    //抗疫智多星聊天接口
    public static final String fightingEpidemic = getServerAddress() + "/apis/dst/ncov/chatrobot";

    public static String getFightingEpidemic() {
        return fightingEpidemic;
    }

    //疫情动态播报
    public static final String updateEpidemic = getServerAddress() + "/apis/dst/ncov/query";

    public static String getUpdateEpidemic() {
        return updateEpidemic;
    }
}
