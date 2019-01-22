package com.pipikai.simplydemo.annotationdemo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

@Aspect
@Service
@Slf4j
public class TokenCheckAspect {

    //    @Pointcut("execution(public * com.pipikai.simplydemo.annotationdemo.TokenTest.test(..))")
    @Pointcut("@annotation(com.pipikai.simplydemo.annotationdemo.TokenCheck)")
    public void handle() {
    }

    @Around("handle()")
    public Object tokenCheck(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("handle()");
        Object[] args = pjp.getArgs();
        Object arg0 = args[0];
        Object arg1 = args[1];
        //...argN

        //do something for arg0 and arg1
        System.out.println("arg0: " + arg0);
        System.out.println("arg1: " + arg1);
        args[1] = (String) arg0 + arg1;

        Object ret = pjp.proceed(args);
        System.out.println("AfterHandle()");
        return ret;
    }

}