package com.wly.exceptions;

/**
 * 自定义非法token异常
 */
public class IllegalTokenException extends RuntimeException{

    public IllegalTokenException(String message) {
        super(message);
    }
}
