package com.pipikai.imooc.design.principle.openclose;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Created by wanzhangkai
 * 2018/11/20 10:45
 * Email: zhangkaiwan@qq.com
 */
@Slf4j
public class Test {

    private static void test1(){
        Course course = new JavaCourse(96, "JAVA开发", new BigDecimal("348"));
        log.info("课程ID：{}，课程名称：{}，课程价格：{}元",
                course.getId(), course.getName(), course.getPrice());
    }

    private static void test2(){
        Course course = new JavaDiscountCourse(96, "JAVA开发", new BigDecimal("348"));
        log.info("课程ID：{}，课程名称：{}，原价：{}元，课程折后价格：{}元",
                course.getId(), course.getName(), ((JavaDiscountCourse) course).getOriginPrice(),course.getPrice());
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}
