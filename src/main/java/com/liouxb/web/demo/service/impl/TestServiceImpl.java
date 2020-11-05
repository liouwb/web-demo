package com.liouxb.web.demo.service.impl;

import com.liouxb.web.demo.domain.Test;
import com.liouxb.web.demo.mapper.TestMapper;
import com.liouxb.web.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liouwb
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public Test getTest() {
        return testMapper.selectById(1);
    }
}
