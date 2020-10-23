package com.example.trxy.bean;

import java.util.List;

public class RangeQueryBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"id":4578,"date":"2020-03-24","start":"2020/03/24 07:30:00","end":"2020/03/24 09:55:00","type":1,"no":"CZ8533","memo":"","no_sub":"","pos_start":"广州","pos_end":"郑州","source":"https://weibo.com/1747173625/IAw8QrMO6?refer_flag=1001030103_&type=comment#_rnd1585276878734","who":"郑州新闻广播 ","verified":1,"created_at":"2020/03/27 10:43:26","updated_at":"2020/03/30 17:52:48"},{"id":4432,"date":"2020-03-17","start":"2020/03/17 09:30:00","end":"2020/03/17 12:00:00","type":1,"no":"CZ3390","memo":"座位号：45C","no_sub":"","pos_start":"广州","pos_end":"郑州","source":"https://weibo.com/ttarticle/p/show?id=2310474484534547644474","who":"洛阳新闻播报 ","verified":1,"created_at":"2020/03/20 14:26:41","updated_at":"2020/03/20 16:06:27"},{"id":4373,"date":"2020-03-07","start":"2020/03/07 13:22:00","end":"2020/03/07 21:50:00","type":2,"no":"K267","memo":"座位：17车厢63号","no_sub":"17号车厢","pos_start":"北京西","pos_end":"郑州","source":"https://weibo.com/ttarticle/p/show?id=2309404481307643085071","who":"郑州发布","verified":1,"created_at":"2020/03/11 16:09:25","updated_at":"2020/03/13 15:42:49"},{"id":3583,"date":"2020-02-02","start":"2020/02/02 00:00:00","end":"2020/02/02 23:59:59","type":1,"no":"HU7685","memo":"","no_sub":"","pos_start":"三亚","pos_end":"郑州","source":"https://baijiahao.baidu.com/s?id=1658628901233831269&wfr=spider&for=pc","who":"河南日报","verified":1,"created_at":"2020/02/17 23:09:20","updated_at":"2020/02/17 23:44:48"},{"id":2999,"date":"2020-01-29","start":"2020/01/29 00:00:00","end":"2020/01/29 23:59:59","type":1,"no":"QW6064","memo":"","no_sub":"","pos_start":"泰国普吉岛","pos_end":"郑州","source":"https://mp.weixin.qq.com/s/arSpzLD1RoWv7tYFwJxhqw","who":"人民日报","verified":1,"created_at":"2020/02/13 12:22:09","updated_at":"2020/02/13 14:47:59"},{"id":1426,"date":"2020-01-28","start":"2020/01/28 00:00:00","end":"2020/01/28 23:59:59","type":1,"no":"VN704","memo":"","no_sub":"","pos_start":"越南","pos_end":"郑州","source":"https://wap.peopleapp.com/article/5098032/4993697","who":"人民日报","verified":1,"created_at":"2020/02/04 01:26:33","updated_at":"2020/02/04 15:03:03"},{"id":2998,"date":"2020-01-28","start":"2020/01/28 00:00:00","end":"2020/01/28 23:59:59","type":1,"no":"HU7755","memo":"","no_sub":"","pos_start":"深圳","pos_end":"郑州","source":"https://mp.weixin.qq.com/s/arSpzLD1RoWv7tYFwJxhqw","who":"人民日报","verified":1,"created_at":"2020/02/13 12:22:09","updated_at":"2020/02/13 14:48:13"},{"id":1989,"date":"2020-01-26","start":"2020/01/26 00:00:00","end":"2020/01/26 23:59:59","type":1,"no":"CA4385","memo":"","no_sub":"","pos_start":"贵阳","pos_end":"郑州","source":"https://mp.weixin.qq.com/s/RPfahGQ_Gg483fv3Bah4BQ","who":"人民日报","verified":1,"created_at":"2020/02/06 14:56:10","updated_at":"2020/02/06 15:09:56"},{"id":2996,"date":"2020-01-25","start":"2020/01/25 00:00:00","end":"2020/01/25 23:59:59","type":1,"no":"PN6398","memo":"","no_sub":"","pos_start":"昆明","pos_end":"郑州","source":"https://mp.weixin.qq.com/s/arSpzLD1RoWv7tYFwJxhqw","who":"人民日报","verified":1,"created_at":"2020/02/13 12:22:09","updated_at":"2020/02/13 14:48:44"},{"id":3015,"date":"2020-01-24","start":"2020/01/24 13:08:00","end":"2020/01/24 17:06:00","type":2,"no":"G2388","memo":"","no_sub":"","pos_start":"大冶","pos_end":"郑州","source":"https://mp.weixin.qq.com/s/arSpzLD1RoWv7tYFwJxhqw","who":"人民日报","verified":1,"created_at":"2020/02/13 12:22:13","updated_at":"2020/02/13 15:12:05"}]
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
         * id : 4578
         * date : 2020-03-24
         * start : 2020/03/24 07:30:00
         * end : 2020/03/24 09:55:00
         * type : 1
         * no : CZ8533
         * memo :
         * no_sub :
         * pos_start : 广州
         * pos_end : 郑州
         * source : https://weibo.com/1747173625/IAw8QrMO6?refer_flag=1001030103_&type=comment#_rnd1585276878734
         * who : 郑州新闻广播
         * verified : 1
         * created_at : 2020/03/27 10:43:26
         * updated_at : 2020/03/30 17:52:48
         */

        private int id;
        private String date;
        private String start;
        private String end;
        private int type;
        private String no;
        private String memo;
        private String no_sub;
        private String pos_start;
        private String pos_end;
        private String source;
        private String who;
        private int verified;
        private String created_at;
        private String updated_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getNo_sub() {
            return no_sub;
        }

        public void setNo_sub(String no_sub) {
            this.no_sub = no_sub;
        }

        public String getPos_start() {
            return pos_start;
        }

        public void setPos_start(String pos_start) {
            this.pos_start = pos_start;
        }

        public String getPos_end() {
            return pos_end;
        }

        public void setPos_end(String pos_end) {
            this.pos_end = pos_end;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public int getVerified() {
            return verified;
        }

        public void setVerified(int verified) {
            this.verified = verified;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
