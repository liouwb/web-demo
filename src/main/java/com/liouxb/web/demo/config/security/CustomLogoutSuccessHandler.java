package com.liouxb.web.demo.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liouxb.web.demo.entity.resp.BaseResp;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liouwb
 */
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    /**
     * 注销登录处理
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        BaseResp resp = new BaseResp(true, "success", 200, "退出登录成功");

        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }
}
