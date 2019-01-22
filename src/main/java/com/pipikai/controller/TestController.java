package com.pipikai.controller;

import com.pipikai.aspect.IpCheck;
import com.pipikai.simplydemo.annotationdemo.TokenTest;
import com.pipikai.pojo.TestObject;
import com.pipikai.service.TestA;
import com.pipikai.service.TestService;
import com.pipikai.utils.HttpResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/7/17 14:43
 */
@RestController
@Slf4j
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestA testA;

    @Autowired
    TestService testService;

    @Autowired
    TokenTest tokenTest;

    @RequestMapping("/getTest")
    public String getTest(){
        return testA.getBName();
    }

    @IpCheck
    @GetMapping(value = "/hello")
    public String test() {
        tokenTest.test("wan", "zhangkai");
        log.info("Hello Test Succuss");
        return "Hello";
    }

    @GetMapping(value = "/hello/{arg}")
    public String test2(@PathVariable(value = "arg", required = false) String str) {
        log.info("Hello Test Succuss");
        return "Hello " + str;
    }

    @PostMapping(value = "/setTest")
    public Object getTestList(@Valid TestObject testObject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return HttpResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return HttpResultUtil.success();
    }

    @GetMapping(value = "/getTest/{id}")
    public Object getTest(@PathVariable("id") Integer id, TestObject testObject) throws Exception {
        return testService.getTest(id);
//        return null;
    }

    @GetMapping(value = "/findOne/{id}")
    public Object findOne(@PathVariable("id") Integer id, TestObject testObject) throws Exception {
//        return testService.findOne(id);
        return null;
    }

    public static void main(String[] args) throws IOException {
        TestObject testObject1 = new TestObject();
        TestObject testObject2 = new TestObject();
//        System.out.println(testObject1 instanceof Object);
        Class c = null;
        try {
            c = Class.forName("com.pipikai.domain.TestObject");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}