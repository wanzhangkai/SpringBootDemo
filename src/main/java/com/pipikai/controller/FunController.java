package com.pipikai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanzhangkai
 * 2018/12/25 13:34
 * Email: zhangkaiwan@qq.com
 */
@Controller
@Slf4j
public class FunController {

    @GetMapping(value = "/hi")
    public String index(){
        return "toLove";
    }

}
