package com.liouxb.web.demo.controller;

import com.liouxb.web.demo.domain.Test;
import com.liouxb.web.demo.entity.resp.TestResp;
import com.liouxb.web.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author liouwb
 */
@RestController
@RequestMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "测试controller")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("test")
    @ApiOperation(value = "测试web接口")
    public String test() {

        return "hello web-demo";
    }

    @PostMapping("testPost")
    @ApiOperation(value = "测试post接口")
    public TestResp testPost() {
        TestResp resp = new TestResp();
        resp.setResult("success test post");

        return resp;
    }

    @PostMapping("get_test")
    @ApiOperation(value = "获取测试用户信息")
    public Test getUserInfo() {

        return testService.getTest();
    }
}
