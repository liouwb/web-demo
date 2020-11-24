package com.liouxb.web.demo.controller;

import com.liouxb.web.demo.entity.req.LoginReq;
import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.entity.resp.TestResp;
import com.liouxb.web.demo.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author liouwb
 */
@Api(tags = "登录管理模块")
@RestController
@RequestMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    @ApiOperation(value = "登录接口")
    public String login(@RequestBody LoginReq req) {

        return loginService.login(req);
    }

    @GetMapping("showCurrentUser")
    @ApiOperation(value = "获取登录用户信息")
    public BaseResp showCurrentUser() {

        return loginService.showCurrentUser();
    }

    @GetMapping("success")
    @ApiOperation(value = "登录成功页面")
    // admin权限可以访问
//    @PreAuthorize("hasRole('ADMIN')")
    public String success() {

        return "登录成功";
    }
}
