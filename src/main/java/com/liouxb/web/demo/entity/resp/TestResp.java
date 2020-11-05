package com.liouxb.web.demo.entity.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liouwb
 */
@ApiModel(value = "测试返回类")
@Data
public class TestResp {
    @ApiModelProperty(value = "测试返回结果字段")
    private String result;
}
