package com.liouxb.web.demo.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.liouxb.web.demo.entity.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录状态处理
 *
 * @author liouwb
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {


    /**
     * 未登录默认返回302，前后端分离这里调整为403
     * <p>
     * 返回格式调整为json
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(new BaseResp(false, "fail", 401, "fail not login")));

        //        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
    }
}
