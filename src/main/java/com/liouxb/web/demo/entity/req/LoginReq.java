package com.liouxb.web.demo.entity.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liouwb
 */
@Data
public class LoginReq {
    @NotNull(message = "{name.notnull}")
    @ApiModelProperty(value = "姓名")
    private String userId;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String pwd;
}
