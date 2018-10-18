package com.pipikai.demo.annotationDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TokenTest {

    @Autowired
    TokenCheckAspect tokenCheckAspect;

//    @PostConstruct
//    public void init() {
//        System.out.println("PostConstruct");
//        test("wan", "zhangkai");
//        System.out.println("AfterPostConstruct");
//    }

    @TokenCheck
    public void test(String str1, String str2) {
        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);
    }

    public static void main(String[] args) {
    }

}