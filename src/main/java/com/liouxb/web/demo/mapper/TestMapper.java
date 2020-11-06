package com.liouxb.web.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liouxb.web.demo.domain.Test;


/**
 * @author liouwb
 */
public interface TestMapper extends BaseMapper<Test> {
    IPage<Test> selectTests(Page<?> page);
}
