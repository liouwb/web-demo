package com.liouxb.web.demo.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liouxb.web.demo.entity.resp.BaseResp;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liouwb
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * 未登录请求处理
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        BaseResp resp = new BaseResp(false, "fail", 400, "没有访问权限");

        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(resp));
    }
}
