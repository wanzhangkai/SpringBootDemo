package com.pipikai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/7/17 14:43
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping(value = "/hello/{string}", method = RequestMethod.GET)
    public String test(@PathVariable("string") String str) {
        log.info("Hello Test Succuss");
        return "Hello " + str;
    }

}