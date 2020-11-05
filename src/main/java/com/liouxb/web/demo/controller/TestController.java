package com.liouxb.web.demo.controller;

import com.liouxb.web.demo.entity.resp.TestResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author liouwb
 */
@RestController
@RequestMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "测试controller")
public class TestController {

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
}
