package com.liouxb.web.demo.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liouxb.web.demo.entity.resp.BaseResp;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liouwb
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 登录成功默认返回302状态，这里调整为200
     **/
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

//        httpServletResponse.setStatus(HttpStatus.OK.value());

        BaseResp resp = new BaseResp(true, "success", 200, "登录成功");

        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }
}
