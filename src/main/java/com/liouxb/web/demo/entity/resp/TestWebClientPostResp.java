package com.liouxb.web.demo.entity.resp;

import lombok.Data;

/**
 * @author liouwb
 */
@Data
public class TestWebClientPostResp {
    private String accessToken;

    private int expiresIn;

    private String scope;
}
