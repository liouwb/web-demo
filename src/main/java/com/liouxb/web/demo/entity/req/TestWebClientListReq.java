package com.liouxb.web.demo.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author liouwb
 */
@Data
@ApiModel(value = " webclient post获取list请求类")
public class TestWebClientListReq {
    @NotNull(message = "authCode不能为空")
    @Size(min = 1, message = "authCode不能为空")
    @ApiModelProperty(value = "authCode")
    private String authCode;

    @NotNull(message = "accessToken不能为空")
    @Size(min = 1, message = "accessToken不能为空")
    @ApiModelProperty(value = "accessToken")
    private String accessToken;
}
