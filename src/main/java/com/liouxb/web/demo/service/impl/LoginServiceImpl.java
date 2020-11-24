package com.liouxb.web.demo.service.impl;

import com.liouxb.web.demo.config.security.CustomUserDetailsService;
import com.liouxb.web.demo.entity.req.LoginReq;
import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.service.LoginService;
import com.liouxb.web.demo.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author liouwb
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Override
    public BaseResp login(LoginReq req) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());

        final String token = jwtTokenUtil.createJwtToken(req);

        log.info("x-token:{}", token);


        return new BaseResp(true, "success", 200, token);
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
