package com.example.trxy.bean;

public class EpidemicInNationwideBean {

    /**
     * code : 200
     * message :
     * data : {"confirmedCount":84478,"confirmedAdd":9,"currentConfirmedCount":165,"currentConfirmedAdd":-16,"suspectedCount":1698,"suspectedAdd":6,"severecasesCount":561,"severecasesAdd":-58,"curedCount":79669,"curedAdd":25,"deadCount":4644,"deathAdd":0,"updateTime":"2020-05-16 23:58:16","sourceDesc":"数据来源为国家卫健委、各省市区卫健委、各省市区政府、港澳台官方渠道公开数据；疑似病例数来自国家卫健委数据，目前为全国数据，未分省市自治区等","description":"病毒: 新型冠状病毒 2019-nCoV;                 传染源: 新型冠状病毒感染的肺炎患者;                 传播途径: 经呼吸道飞沫传播， 亦可通过接触传播， 存在粪 - 口传播可能性;                易感人群： 人群普遍易感。 老年人及有基础疾病者感染后病情较重， 儿童及婴幼儿也有发病;                潜伏期： 一般为 3～ 7 天， 最长不超过 14 天， 潜伏期内存在传染性;                宿主： 野生动物， 可能为中华菊头蝠 "}
     */

    private String code;
    private String message;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * confirmedCount : 84478
         * confirmedAdd : 9
         * currentConfirmedCount : 165
         * currentConfirmedAdd : -16
         * suspectedCount : 1698
         * suspectedAdd : 6
         * severecasesCount : 561
         * severecasesAdd : -58
         * curedCount : 79669
         * curedAdd : 25
         * deadCount : 4644
         * deathAdd : 0
         * updateTime : 2020-05-16 23:58:16
         * sourceDesc : 数据来源为国家卫健委、各省市区卫健委、各省市区政府、港澳台官方渠道公开数据；疑似病例数来自国家卫健委数据，目前为全国数据，未分省市自治区等
         * description : 病毒: 新型冠状病毒 2019-nCoV;                 传染源: 新型冠状病毒感染的肺炎患者;                 传播途径: 经呼吸道飞沫传播， 亦可通过接触传播， 存在粪 - 口传播可能性;                易感人群： 人群普遍易感。 老年人及有基础疾病者感染后病情较重， 儿童及婴幼儿也有发病;                潜伏期： 一般为 3～ 7 天， 最长不超过 14 天， 潜伏期内存在传染性;                宿主： 野生动物， 可能为中华菊头蝠
         */

        private int confirmedCount;
        private int confirmedAdd;
        private int currentConfirmedCount;
        private int currentConfirmedAdd;
        private int suspectedCount;
        private int suspectedAdd;
        private int severecasesCount;
        private int severecasesAdd;
        private int curedCount;
        private int curedAdd;
        private int deadCount;
        private int deathAdd;
        private String updateTime;
        private String sourceDesc;
        private String description;

        public int getConfirmedCount() {
            return confirmedCount;
        }

        public void setConfirmedCount(int confirmedCount) {
            this.confirmedCount = confirmedCount;
        }

        public int getConfirmedAdd() {
            return confirmedAdd;
        }

        public void setConfirmedAdd(int confirmedAdd) {
            this.confirmedAdd = confirmedAdd;
        }

        public int getCurrentConfirmedCount() {
            return currentConfirmedCount;
        }

        public void setCurrentConfirmedCount(int currentConfirmedCount) {
            this.currentConfirmedCount = currentConfirmedCount;
        }

        public int getCurrentConfirmedAdd() {
            return currentConfirmedAdd;
        }

        public void setCurrentConfirmedAdd(int currentConfirmedAdd) {
            this.currentConfirmedAdd = currentConfirmedAdd;
        }

        public int getSuspectedCount() {
            return suspectedCount;
        }

        public void setSuspectedCount(int suspectedCount) {
            this.suspectedCount = suspectedCount;
        }

        public int getSuspectedAdd() {
            return suspectedAdd;
        }

        public void setSuspectedAdd(int suspectedAdd) {
            this.suspectedAdd = suspectedAdd;
        }

        public int getSeverecasesCount() {
            return severecasesCount;
        }

        public void setSeverecasesCount(int severecasesCount) {
            this.severecasesCount = severecasesCount;
        }

        public int getSeverecasesAdd() {
            return severecasesAdd;
        }

        public void setSeverecasesAdd(int severecasesAdd) {
            this.severecasesAdd = severecasesAdd;
        }

        public int getCuredCount() {
            return curedCount;
        }

        public void setCuredCount(int curedCount) {
            this.curedCount = curedCount;
        }

        public int getCuredAdd() {
            return curedAdd;
        }

        public void setCuredAdd(int curedAdd) {
            this.curedAdd = curedAdd;
        }

        public int getDeadCount() {
            return deadCount;
        }

        public void setDeadCount(int deadCount) {
            this.deadCount = deadCount;
        }

        public int getDeathAdd() {
            return deathAdd;
        }

        public void setDeathAdd(int deathAdd) {
            this.deathAdd = deathAdd;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getSourceDesc() {
            return sourceDesc;
        }

        public void setSourceDesc(String sourceDesc) {
            this.sourceDesc = sourceDesc;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
