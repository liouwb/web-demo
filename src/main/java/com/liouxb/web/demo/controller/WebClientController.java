package com.liouxb.web.demo.controller;

import com.liouxb.web.demo.entity.req.TestWebClientListReq;
import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.entity.resp.TestWebClientPostResp;
import com.liouxb.web.demo.service.WebClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author liouwb
 */
@RestController
@RequestMapping(value = "webClient")
@Api(tags = "webclient api调用")
public class WebClientController {
    @Autowired
    private WebClientService webClientService;

    @GetMapping("testWebPostSingleBean")
    @ApiOperation(value = "测试webclient post请求，获取单个实体数据")
    public BaseResp<TestWebClientPostResp> testWebPostSingleBean() {

        return webClientService.testWebPostSingleBean();
    }

    @PostMapping("testWebPostList")
    @ApiOperation(value = "测试webclient post请求，获取集合")
    public BaseResp testWebPostList(@RequestBody @Valid TestWebClientListReq req) {

        return webClientService.testWebPostList(req);
    }

}
