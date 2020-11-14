package com.liouxb.web.demo.service.impl;

import com.liouxb.web.demo.domain.Test;
import com.liouxb.web.demo.entity.req.TestValidReq;
import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.entity.resp.TestValidResp;
import com.liouxb.web.demo.mapper.TestMapper;
import com.liouxb.web.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liouwb
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public Test getTest() {
        return testMapper.selectById(1);
    }

    @Override
    public BaseResp<TestValidResp> testValid(TestValidReq req) {
        log.info("测试参数校验");
        log.error("测试参数校验");
        TestValidResp validResp = new TestValidResp("参数校验成功");
        BaseResp resp = new BaseResp(true, "success", 200, validResp);

        return resp;
    }
}
