package com.liouxb.web.demo.entity.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author liouwb
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestWebClientPostReq {

    private String clientId;


    private String clientSecret;

    private String grantType;
}
