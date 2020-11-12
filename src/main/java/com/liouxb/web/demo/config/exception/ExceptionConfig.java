package com.liouxb.web.demo.config.exception;

import com.liouxb.web.demo.entity.resp.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author liouwb
 */
@Slf4j
@RestControllerAdvice
public class ExceptionConfig {

    /**
     * 请求参数校验不通过
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResp requestParameterException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        return new BaseResp(false, "fail", 500, e.getBindingResult().getFieldError().getDefaultMessage());
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
    public BaseResp Exception(Exception e) {
        log.error(e.getMessage());

        return new BaseResp(false, "fail", 500, e.getMessage().split(":")[0]);
    }

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public BaseResp Exception(MyException e) {
        log.error(e.getMessage());

        return new BaseResp(false, "fail", 500, e.getMessage().split(":")[0]);
    }
}
