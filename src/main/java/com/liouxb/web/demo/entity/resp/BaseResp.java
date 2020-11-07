package com.liouxb.web.demo.entity.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liouwb
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = " 返回基础类")
public class BaseResp<T> {
    @ApiModelProperty(value = "结果")
    private boolean result;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "返回数据")
    private T data;

}
