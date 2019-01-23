package com.pipikai.simplydemo.overflowdemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2019/1/17 16:33
 */
@Slf4j
@Data
public class Person {

    private String name;
    private String name2;
    private Integer age;

    public Person(String name, String name2, Integer age) {
        this.name = name;
        this.name2 = name2;
        this.age = age;
    }

}
