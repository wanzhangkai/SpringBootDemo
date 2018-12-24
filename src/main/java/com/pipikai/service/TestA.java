package com.pipikai.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wanzhangkai
 * 2018/12/24 11:14
 * Email: zhangkaiwan@qq.com
 */
@Component
@Data
public class TestA {
    private int age;

    @Autowired
    private TestB b;

    public String getBName() {
        return b.getName();
    }
}
