package com.wly.exception;

/**
 * 自定义非法参数异常
 */
public class IllegalParamsException extends RuntimeException{

    public IllegalParamsException(String message) {
        super(message);
    }
}
