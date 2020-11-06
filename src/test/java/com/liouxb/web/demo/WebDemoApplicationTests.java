package com.liouxb.web.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liouxb.web.demo.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WebDemoApplicationTests {
    @Autowired
    private TestMapper testMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {
        QueryWrapper<com.liouxb.web.demo.domain.Test> queryWrapper = new QueryWrapper<>();
        List<com.liouxb.web.demo.domain.Test> userList = testMapper.selectList(queryWrapper);

        userList.forEach(System.out::println);
    }
}
