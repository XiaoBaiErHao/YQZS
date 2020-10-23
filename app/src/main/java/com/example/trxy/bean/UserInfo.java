package com.example.trxy.bean;

public class UserInfo {

    /**
     * status : 1
     * state : success
     * msg : 获取用户信息成功
     * referer : null
     * result : {"id":"05b8ebc5f5da4ef69ea3b67ad0eb1424","userLoginName":"18685829589","userLoginPwd":"$2a$10$UQX6liK.A5pFq70IIsoYs.4cus3xpq7BkOx6WzCLGW89nmibpMnfq","plaintPwd":null,"userName":null,"userHeadUrl":null,"userSex":null,"userTel":null,"userLevel":"0","createTime":"2020-05-29 01:44:23","createUserId":"4868089697","createUserName":null}
     */

    private int status;
    private String state;
    private String msg;
    private Object referer;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getReferer() {
        return referer;
    }

    public void setReferer(Object referer) {
        this.referer = referer;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 05b8ebc5f5da4ef69ea3b67ad0eb1424
         * userLoginName : 18685829589
         * userLoginPwd : $2a$10$UQX6liK.A5pFq70IIsoYs.4cus3xpq7BkOx6WzCLGW89nmibpMnfq
         * plaintPwd : null
         * userName : null
         * userHeadUrl : null
         * userSex : null
         * userTel : null
         * userLevel : 0
         * createTime : 2020-05-29 01:44:23
         * createUserId : 4868089697
         * createUserName : null
         */

        private String id;
        private String userLoginName;
        private String userLoginPwd;
        private Object plaintPwd;
        private Object userName;
        private Object userHeadUrl;
        private Object userSex;
        private Object userTel;
        private String userLevel;
        private String createTime;
        private String createUserId;
        private Object createUserName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserLoginName() {
            return userLoginName;
        }

        public void setUserLoginName(String userLoginName) {
            this.userLoginName = userLoginName;
        }

        public String getUserLoginPwd() {
            return userLoginPwd;
        }

        public void setUserLoginPwd(String userLoginPwd) {
            this.userLoginPwd = userLoginPwd;
        }

        public Object getPlaintPwd() {
            return plaintPwd;
        }

        public void setPlaintPwd(Object plaintPwd) {
            this.plaintPwd = plaintPwd;
        }

        public Object getUserName() {
            return userName;
        }

        public void setUserName(Object userName) {
            this.userName = userName;
        }

        public Object getUserHeadUrl() {
            return userHeadUrl;
        }

        public void setUserHeadUrl(Object userHeadUrl) {
            this.userHeadUrl = userHeadUrl;
        }

        public Object getUserSex() {
            return userSex;
        }

        public void setUserSex(Object userSex) {
            this.userSex = userSex;
        }

        public Object getUserTel() {
            return userTel;
        }

        public void setUserTel(Object userTel) {
            this.userTel = userTel;
        }

        public String getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(String userLevel) {
            this.userLevel = userLevel;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }

        public Object getCreateUserName() {
            return createUserName;
        }

        public void setCreateUserName(Object createUserName) {
            this.createUserName = createUserName;
        }


        @Override
        public String toString() {
            return "ResultBean{" +
                    "id='" + id + '\'' +
                    ", userLoginName='" + userLoginName + '\'' +
                    ", userLoginPwd='" + userLoginPwd + '\'' +
                    ", plaintPwd=" + plaintPwd +
                    ", userName=" + userName +
                    ", userHeadUrl=" + userHeadUrl +
                    ", userSex=" + userSex +
                    ", userTel=" + userTel +
                    ", userLevel='" + userLevel + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", createUserId='" + createUserId + '\'' +
                    ", createUserName=" + createUserName +
                    '}';
        }
    }



}
