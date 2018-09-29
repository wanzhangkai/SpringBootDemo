package com.pipikai.exception;

import com.pipikai.enums.HttpResultEnum;
import lombok.Data;

/**
 * extends RuntimeException 可以进行事物回滚而继承Exception不会。
 */
@Data
public class TestException extends RuntimeException {

    private Integer code;

    public TestException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public TestException(HttpResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
