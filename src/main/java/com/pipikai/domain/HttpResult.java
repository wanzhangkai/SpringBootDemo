package com.pipikai.domain;

import lombok.Data;

/**
 * Http回复类
 * Created by wanzhangkai
 * 2018年9月28日17:29:20
 */
@Data
public class HttpResult<T> {

    private Integer code;
    private String msg;
    private T data;

}
