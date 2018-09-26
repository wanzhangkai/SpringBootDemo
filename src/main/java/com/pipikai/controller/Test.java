package com.pipikai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/7/17 14:43
 */
@RestController
@Slf4j
public class Test {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test() {
        log.info("Hello Test Succuss");
        return "Hello";
    }

}