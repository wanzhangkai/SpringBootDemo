package com.pipikai.controller;

import com.mysql.jdbc.util.ResultSetUtil;
import com.pipikai.domain.HttpResult;
import com.pipikai.domain.Test;
import com.pipikai.repository.TestRepository;
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
    public Object getTestList(@Valid Test test, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            HttpResult result = new HttpResult();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        HttpResult result = new HttpResult();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(testRepository.save(test));
        return  result;
    }

}