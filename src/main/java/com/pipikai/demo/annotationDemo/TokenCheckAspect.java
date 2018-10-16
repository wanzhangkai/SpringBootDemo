package com.pipikai.demo.annotationDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class TokenCheckAspect {

    @Autowired
    TokenTest tokenTest;

    @Pointcut("@annotation(com.pipikai.demo.annotationDemo.TokenCheck)")
    public void service() {
    }

    @Around("service()")
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
        System.out.println("handle()2");
        return ret;

//        if (userId == null)
//            System.out.println("");
//        User user = args[1] == null ? new User() : (User) args[1];
//        user.setId(userId);
//        args[1] = user;
//        Object retVal = pjp.proceed(args);
//        return retVal;
    }

}