package com.example.trxy.bean;

import java.util.List;

public class MakeDefiniteDiagnosisBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"locale":"新街口外大街15号院","address":"北京市海淀区北太平庄街道新街口外大街15号院","lng":"116.370025","lat":"39.963371","source":"北京日报"},{"locale":"民族大学西路66号鑫德家园","address":"北京市海淀区紫竹院街道民族大学西路66号鑫德家园","lng":"116.3173","lat":"39.9495","source":"北京日报"},{"locale":"中科院东南小区","address":"北京市海淀区中关村街道中科院东南小区","lng":"116.323593","lat":"39.978989","source":"北京日报"},{"locale":"北京师范大学小区","address":"北京市海淀区北太平庄街道北京师范大学小区","lng":"116.365944","lat":"39.960609","source":"北京日报"},{"locale":"玉海园二里小区","address":"北京市海淀区田村路街道玉海园二里小区","lng":"116.253677","lat":"39.919514","source":"北京日报"},{"locale":"知春路82号院小区","address":"北京市海淀区中关村街道知春路82号院小区","lng":"116.329456","lat":"39.974753","source":"北京日报"},{"locale":"软件小区","address":"北京市海淀区中关村街道软件小区","lng":"116.335518","lat":"39.98159","source":"北京日报"},{"locale":"鑫德嘉园","address":"北京市海淀区紫竹院街道鑫德嘉园","lng":"116.317482","lat":"39.949142","source":"北京日报"},{"locale":"唐家岭新城T05小区","address":"北京市海淀区西北旺（地区）镇唐家岭新城T05小区","lng":"116.275215","lat":"40.039284","source":"北京日报"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * locale : 新街口外大街15号院
         * address : 北京市海淀区北太平庄街道新街口外大街15号院
         * lng : 116.370025
         * lat : 39.963371
         * source : 北京日报
         */

        private String locale;
        private String address;
        private String lng;
        private String lat;
        private String source;

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
