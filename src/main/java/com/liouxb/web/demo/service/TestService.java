package com.liouxb.web.demo.service;

import com.liouxb.web.demo.domain.Test;
import com.liouxb.web.demo.entity.req.TestValidReq;
import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.entity.resp.TestValidResp;

/**
 * @author liouwb
 */
public interface TestService {
    Test getTest();

    /**
     * 测试测试校验
     *
     * @param req
     * @return
     */
    BaseResp<TestValidResp> testValid(TestValidReq req);
}
