package com.liouxb.web.demo.service;

import com.liouxb.web.demo.entity.req.TestWebClientListReq;
import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.entity.resp.TestWebClientPostResp;

/**
 * @author liouwb
 */
public interface WebClientService {
    BaseResp<TestWebClientPostResp> testWebPostSingleBean();

    BaseResp testWebPostList(TestWebClientListReq req);
}
