package com.liouxb.web.demo.service.impl;

import com.liouxb.web.demo.entity.req.LoginReq;
import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author liouwb
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(LoginReq req) {
        log.info("1234");



        return "登录成功";
    }

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    @Override
    public BaseResp showCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("当前登陆用户：{}", name);

        return new BaseResp(true, "success", 200, authentication);
    }
}
