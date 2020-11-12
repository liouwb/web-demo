package com.liouxb.web.demo.config.exception;

/**
 * 自定义异常处理
 *
 * @author liouwb
 */
public class MyException extends RuntimeException {

    public MyException(String msg) {
        super(msg);
    }
}
