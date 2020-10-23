package com.example.trxy.bean;

import java.util.List;

public class RumorIdentificationBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":"48f277179821d0ad52d4c09f9fc97a1d","date":"2020-05-01","title":"泰国猫咪疫情期间违反外出禁令被捕，\u201c罪犯照\u201d流出","explain":"假新闻","imgsrc":"https://p.qpic.cn/jiaozhen/0/ca0b94ae5032c8bb50e4840a5fdfc8ff/0?imageView2/2/w/150/h/90","markstyle":"fake","desc":"网传的照片并非近期拍摄，而是在新冠肺炎疫情发生前就已出现在网络...","author":"腾讯新闻旗下专业事实查证平台"},{"id":"c4522920fcdf087f1da84a7ff4980849","date":"2020-04-30","title":"已有抗体的新冠肺炎治愈者不会再次感染","explain":"尚无定论","imgsrc":"https://p.qpic.cn/jiaozhen/0/8e7bbb10069474012a12de7f0b1b1caf/0?imageView2/2/w/150/h/90","markstyle":"doubt","desc":"目前尚无证据表明...","author":"联合国系统内卫生问题的指导和协调机构"},{"id":"f394c4ce61e91c3632372f5b20587f62","date":"2020-04-29","title":"吸烟者可能较易感染新型冠状病毒","explain":"确实如此","imgsrc":"https://p.qpic.cn/jiaozhen/0/8c45f02d49e2422a014e08fa781a6765/0?imageView2/2/w/150/h/90","markstyle":"true","desc":"吸烟者可能较易感染COVID-19...","author":"联合国系统内卫生问题的指导和协调机构"},{"id":"616f1656f8ba420f1707adef67a4271c","date":"2020-04-28","title":"儿童佩戴N95口罩可能会造成不可逆伤害","explain":"确实如此","imgsrc":"https://p.qpic.cn/jiaozhen/0/b2d344946f67b60735274c79e43e6fc8/0?imageView2/2/w/150/h/90","markstyle":"true","desc":"现在市面上有的N95口罩，由于口罩过滤性强，单位呼吸空气量减少...","author":"药理学硕士，知贝儿科药师"},{"id":"594d6d05040c35a57fbbf5cbc667b6a7","date":"2020-04-28","title":"英国新冠疫苗人体试验先行者Elisa已死亡","explain":"谣言","imgsrc":"https://p.qpic.cn/jiaozhen/0/0760371c32ce31875cee4c288834e893/0?imageView2/2/w/150/h/90","markstyle":"fake","desc":"据BBC报道...","author":"腾讯新闻旗下专业事实查证平台"},{"id":"c07622943d5fe51f4d6e0886ad851c23","date":"2020-04-28","title":"王辰院士表示中国已决定实行\u201c群体免疫\u201d","explain":"谣言","imgsrc":"https://p.qpic.cn/jiaozhen/0/a079a81da1e3d261e112e8139849e789/0?imageView2/2/w/150/h/90","markstyle":"fake","desc":"据公开报道和资料...","author":"腾讯新闻旗下专业事实查证平台"},{"id":"e5256e5d645b686c024e1f7d513732ee","date":"2020-04-26","title":"全国31省市摘口罩时间表公布","explain":"谣言","imgsrc":"//jiaozhen-70111.picnjc.qpic.cn/w2C1rgCyDJ1ZhvqaLxFMoA?imageView2/2/w/150/h/90","markstyle":"fake","desc":"网上流传的\u201c摘口罩时间表\u201d并非官方信息，应是网友自己整理发布...","author":"腾讯新闻旗下专业事实查证平台"},{"id":"8c189620865ebe5cbd5623f9746798b0","date":"2020-04-25","title":"商务部对外贸易司指定5家企业生产出口医疗物资","explain":"谣言","imgsrc":"https://p.qpic.cn/jiaozhen/0/375dc412f345d4ea821b8dbe67699456/0?imageView2/2/w/150/h/90","markstyle":"fake","desc":"2020年4月21日，商务部官网发布《商务部对外贸易司郑重声明》...","author":"较真团队"},{"id":"f19b243999e3bfa06f8f9407b5354aad","date":"2020-04-24","title":"脚上起\u201c水痘\u201d、失去嗅觉和味觉，是新冠新症状","explain":"尚无定论","imgsrc":"https://p.qpic.cn/jiaozhen/0/7fa366e763d779b3e4dda8a9f902da32/0?imageView2/2/w/150/h/90","markstyle":"doubt","desc":"近日...","author":"卓正医疗皮肤科医生"},{"id":"2752ad5f197001868fdbb00562069e79","date":"2020-04-23","title":"新冠肺炎的R0是5.7，高于常见的流行病","explain":"尚无定论","imgsrc":"https://p.qpic.cn/jiaozhen/0/3f5a166c54f7bc8144f5429f5369699a/0?imageView2/2/w/150/h/90","markstyle":"doubt","desc":"R0即基本传染数...","author":"中国科学院生物学博士"}]
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
         * id : 48f277179821d0ad52d4c09f9fc97a1d
         * date : 2020-05-01
         * title : 泰国猫咪疫情期间违反外出禁令被捕，“罪犯照”流出
         * explain : 假新闻
         * imgsrc : https://p.qpic.cn/jiaozhen/0/ca0b94ae5032c8bb50e4840a5fdfc8ff/0?imageView2/2/w/150/h/90
         * markstyle : fake
         * desc : 网传的照片并非近期拍摄，而是在新冠肺炎疫情发生前就已出现在网络...
         * author : 腾讯新闻旗下专业事实查证平台
         */

        private String id;
        private String date;
        private String title;
        private String explain;
        private String imgsrc;
        private String markstyle;
        private String desc;
        private String author;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getMarkstyle() {
            return markstyle;
        }

        public void setMarkstyle(String markstyle) {
            this.markstyle = markstyle;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
