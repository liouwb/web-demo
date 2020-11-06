package com.liouxb.web.demo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liouxb.web.demo.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebDemoApplicationTests {
    @Autowired
    private TestMapper testMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {
        Page<com.liouxb.web.demo.domain.Test> page=new Page<>();
        page.setCurrent(1);
        page.setSize(2);

        IPage<com.liouxb.web.demo.domain.Test> tests = testMapper.selectTests(page);

        tests.getRecords().forEach(System.out::println);
    }

}
