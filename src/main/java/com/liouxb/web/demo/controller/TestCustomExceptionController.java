package com.liouxb.web.demo.controller;

import com.liouxb.web.demo.config.exception.MyException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liouwb
 */
@RestController
@RequestMapping(value = "customException", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "自定义异常测试")
public class TestCustomExceptionController {

    @GetMapping("testCustomException")
    @ApiOperation(value = "自定义异常处理")
    public String testCustomException() {

        throw new MyException("自定义异常");
    }

    @GetMapping("testExc")
    @ApiOperation(value = "系统异常")
    public String testExc() {

        int a = 1 / 0;

        return "hello web-demo";
    }
}
