package com.liouxb.web.demo.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liouwb
 */
@Data
@ApiModel(value = "测试参数校验请求类")
public class TestValidReq {
    @NotNull(message = "{name.notnull}")
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
//    @Min(value = 1, message = "{age.notempty}")
    private int age;
}
