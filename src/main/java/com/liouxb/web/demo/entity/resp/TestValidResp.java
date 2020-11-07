package com.liouxb.web.demo.entity.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liouwb
 */
@ApiModel(value = "测试参数校验返回类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestValidResp {
    @ApiModelProperty(value = "数据结果")
    private String result;
}
