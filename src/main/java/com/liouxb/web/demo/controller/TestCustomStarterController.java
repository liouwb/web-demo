package com.liouxb.web.demo.controller;

import com.liouxb.starter.custom.service.MyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liouwb
 */
@RestController
@RequestMapping(value = "customStarter", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "测试自定义启动器类")
public class TestCustomStarterController {
    @Autowired
    private MyService myService;

    @GetMapping("testCustomStart")
    @ApiOperation(value = "测试web接口")
    public String testCustomStart() {

        return myService.starterTest();
    }
}
