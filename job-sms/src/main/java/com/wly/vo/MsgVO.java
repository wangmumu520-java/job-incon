package com.wly.vo;

public class MsgVO {
    //用来接收手机号
    private String phone;
    //接收验证码
    private String captcha;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
