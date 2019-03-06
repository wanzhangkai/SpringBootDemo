package com.pipikai.controller;

import com.pipikai.simplydemo.annotationdemo.TokenCheck;
import lombok.extern.slf4j.Slf4j;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/7/17 14:43
 */
@RestController
@Slf4j
@RequestMapping(value = "/hello")
public class HelloController {

    @PostMapping()
    public Map test(@RequestParam(value = "str",required = false) String str) {
        log.info("Hello Test Succuss");
        System.out.println("PostConstruct");
        test("wan", "zhangkai");
        System.out.println("AfterPostConstruct");
        Map requestMap = new HashMap();
        requestMap.put("Hello","wanzhangkai");
        return requestMap;
    }

    @TokenCheck
    public void test(String str1, String str2) {
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);
    }

}