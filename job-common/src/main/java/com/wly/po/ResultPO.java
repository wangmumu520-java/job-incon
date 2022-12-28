package com.wly.po;

public class ResultPO {
    //返回执行结果状态
    public Boolean success;
    //返回执行结果消息
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
