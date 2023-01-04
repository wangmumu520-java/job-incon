package com.wly.exception;

/**
 * 自定义非法异常
 */
public class IllegalException extends RuntimeException{

    public IllegalException(String message) {
        super(message);
    }
}
