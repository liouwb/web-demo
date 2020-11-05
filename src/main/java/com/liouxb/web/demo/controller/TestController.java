package com.liouxb.web.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liouwb
 */
@RestController
@RequestMapping(value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @GetMapping("test")
    public String test() {
        return "hello web-demo";
    }

}
