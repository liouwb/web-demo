package com.liouxb.web.demo.config.exception;

import com.liouxb.web.demo.entity.resp.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Objects;

/**
 * @author liouwb
 */
@Slf4j
@RestControllerAdvice
public class ExceptionConfig {


    /**
     * 没有请求体的校验
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public BaseResp requestParameterException(HttpMessageNotReadableException e) {
        log.info(e.getMessage());
        log.error(e.getMessage());
        return new BaseResp(false, "fail", 500, "请求参数不能为空");
    }

    /**
     * 请求参数校验不通过
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResp requestParameterException(MethodArgumentNotValidException e) {
        log.info(e.getMessage());
        log.error(e.getMessage());

        return new BaseResp(false, "fail", 500, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * 404异常处理
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public BaseResp requestParameterException(NoHandlerFoundException e) {
        log.error(e.getMessage());

        return new BaseResp(false, "fail", 500, e.getMessage().split(":")[0]);
    }

    /**
     * 运行时异常处理
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResp runtimeException(RuntimeException e) {
        log.error(e.getMessage());

        return new BaseResp(false, "fail", 500, e.getMessage().split(":")[0]);
    }

    /**
     * 抛出所有未处理的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResp exception(Exception e) {
        log.error(e.getMessage());

        return new BaseResp(false, "fail", 500, e.getMessage().split(":")[0]);
    }

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public BaseResp myException(MyException e) {
        log.error(e.getMessage());

        return new BaseResp(false, "fail", 500, e.getMessage().split(":")[0]);
    }
}
