package com.pipikai.controller;

import com.pipikai.domain.TestObject;
import com.pipikai.repository.TestRepository;
import com.pipikai.service.TestService;
import com.pipikai.utils.HttpResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/7/17 14:43
 */
@RestController
@Slf4j
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestService testService;

    @GetMapping(value = "/hello")
    public String test() {
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
        return HttpResultUtil.success(testRepository.save(testObject));
    }

    @GetMapping(value = "/getTest/{id}")
    public Object getTest(@PathVariable("id") Integer id, TestObject testObject) throws Exception {
        return testService.getTest(id);
    }

    @GetMapping(value = "/findOne/{id}")
    public Object findOne(@PathVariable("id") Integer id, TestObject testObject) throws Exception {
        return testService.findOne(id);
    }

    public static void main(String[] args) {
        TestObject testObject1 = new TestObject();
        TestObject testObject2 = new TestObject();
        System.out.println(testObject1 instanceof Object);
        Class c = null;
        try {
            c = Class.forName("com.pipikai.domain.TestObject");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c == testObject1.getClass());

        try {
            TestObject testObject3 = (TestObject) c.newInstance();
            System.out.println(testObject3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Class c2 = void.class;
        Class c3 = Double.class;
        Class c4 = double.class;
        if (c3.getSimpleName().equals("Double")) {
            System.out.println(c3.getSimpleName());
        }
        TestController testController = new TestController();
        System.out.println(testController);
        System.out.println(testController.getCla());
        System.out.println(testController == testController.getCla());
    }

    public TestController getCla() {
        return this;
    }

}