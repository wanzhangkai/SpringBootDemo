package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/7/17 14:43
 */
@RestController
@Slf4j
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping()
    public String test() {
        log.info("Hello Test Succuss");
        return "Hello";
    }

}