package com.pipikai.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    @Pointcut("execution(public * com.pipikai.controller.TestController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore() {
        System.out.println("doBefore()");
    }

    @After("log()")
    public void doAfter() {
        System.out.println("doAfter()");
    }

}
