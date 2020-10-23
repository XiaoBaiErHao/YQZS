package com.example.trxy.bean;

public class UserOperate {

    /**
     * status : 1
     * state : success
     * msg : 获取用户信息成功
     * referer : null
     * result : null
     */

    private int status;
    private String state;
    private String msg;
    private Object referer;
    private Object result;

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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "UserOperate{" +
                "status=" + status +
                ", state='" + state + '\'' +
                ", msg='" + msg + '\'' +
                ", referer=" + referer +
                ", result=" + result +
                '}';
    }
}
