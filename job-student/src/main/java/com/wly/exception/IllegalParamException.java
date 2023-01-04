package com.wly.exception;

/**
 * 自定义非法参数异常
 */
public class IllegalParamException extends RuntimeException{

    public IllegalParamException(String message) {
        super(message);
    }
}
