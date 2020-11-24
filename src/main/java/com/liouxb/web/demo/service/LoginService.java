package com.liouxb.web.demo.service;

import com.liouxb.web.demo.entity.req.LoginReq;
import com.liouxb.web.demo.entity.resp.BaseResp;

/**
 * @author liouwb
 */
public interface LoginService {
    BaseResp login(LoginReq req);

    BaseResp showCurrentUser();
}
