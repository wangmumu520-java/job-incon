package com.wly.exception;

/**
 * 自定义非法验证码异常
 */
public class IllegalCaptchaException extends RuntimeException{

    public IllegalCaptchaException(String message) {
        super(message);
    }
}
