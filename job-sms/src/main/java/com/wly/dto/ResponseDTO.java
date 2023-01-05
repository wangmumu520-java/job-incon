package com.wly.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    //返回执行结果状态
    public Boolean success;
    //返回执行结果消息
    private String message;
}
