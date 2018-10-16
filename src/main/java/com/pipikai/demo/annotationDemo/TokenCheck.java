package com.pipikai.demo.annotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 注解+AOP demo
 * 对注解进行AOP
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {
    public String test() default "1";
//    String value() default "1";
}
