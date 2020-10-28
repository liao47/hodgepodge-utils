package com.liao47.common.exception;

/**
 * 自定义异常类
 * @author liaoshiqing
 * @date 2020/10/28 11:38
 */
public class CustomException extends RuntimeException {

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
