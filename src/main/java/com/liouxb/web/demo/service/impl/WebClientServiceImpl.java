package com.liouxb.web.demo.service.impl;

import com.liouxb.web.demo.entity.req.TestWebClientListReq;
import com.liouxb.web.demo.entity.req.TestWebClientPostReq;
import com.liouxb.web.demo.entity.resp.BaseResp;
import com.liouxb.web.demo.entity.resp.TestWebClientListResp;
import com.liouxb.web.demo.entity.resp.TestWebClientPostResp;
import com.liouxb.web.demo.service.WebClientService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author liouwb
 */
@Service
public class WebClientServiceImpl implements WebClientService {
    /**
     * 测试webclient post请求，获取单个实体数据
     *
     * @return
     */
    @Override
    public BaseResp<TestWebClientPostResp> testWebPostSingleBean() {

        WebClient webClient = WebClient.create("http://localhost:7000/openapi");
        TestWebClientPostReq body = new TestWebClientPostReq("123456", "liouxb", "123");

        // 获取单个实体数据对象
        Mono<TestWebClientPostResp> mono = webClient.post()
                .uri("/auth/access_token")
//                .contentType(MediaType.APPLICATION_JSON)
                // 设置头信息
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                // body数据
                .bodyValue(body)
                // 发起请求并获取响应
                .retrieve()
                // 响应类型
                .bodyToMono(TestWebClientPostResp.class);

//        mono.subscribe(System.out::println);

        // 获取数据
        TestWebClientPostResp resp = mono.block();

        BaseResp baseResp = new BaseResp(true, "success", 200, null);
        baseResp.setData(resp);

        return baseResp;
    }

    /**
     * 获取集合
     *
     * @return
     */
    @Override
    public BaseResp testWebPostList(TestWebClientListReq req) {
        WebClient webClient = WebClient.create("http://localhost:7000/openapi");

        // 获取单个实体数据对象
        Flux<TestWebClientListResp> flux = webClient.post()
                .uri("/test/getUsers")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(req)
                .retrieve()
                .bodyToFlux(TestWebClientListResp.class);

        // 获取数据
        List<TestWebClientListResp> resp = flux.collectList().block();

//        flux.subscribe(System.out::println);

        BaseResp baseResp = new BaseResp(true, "success", 200, null);
        baseResp.setData(resp);

        return baseResp;
    }


}
