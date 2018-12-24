package com.pipikai.handle;

import com.pipikai.domain.HttpResult;
import com.pipikai.enums.HttpResultEnum;
import com.pipikai.exception.TestException;
import com.pipikai.utils.HttpResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * 拦截controller的异常
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult testHandle(Exception e) {
        if (e instanceof TestException) {
            TestException exception = (TestException) e;
            return HttpResultUtil.error(exception.getCode(), exception.getMessage());
        } else {
            log.info("【系统异常】{}", e);
            return HttpResultUtil.error(-1, "未知异常");
        }
    }

}
