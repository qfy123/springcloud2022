package com.qfy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }
    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }
}
