package com.liouxb.web.demo.config.exception;

import com.liouxb.web.demo.entity.resp.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liouwb
 */
@RestControllerAdvice
@Slf4j
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
}
