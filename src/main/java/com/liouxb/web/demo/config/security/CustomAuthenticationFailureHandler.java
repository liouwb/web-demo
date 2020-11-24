package com.liouxb.web.demo.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liouxb.web.demo.entity.resp.BaseResp;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liouwb
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        BaseResp resp = new BaseResp(false, "fail", 400, "登录失败");

        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }
}
