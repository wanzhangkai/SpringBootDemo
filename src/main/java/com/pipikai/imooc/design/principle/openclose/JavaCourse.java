package com.pipikai.imooc.design.principle.openclose;

import java.math.BigDecimal;

/**
 * Created by wanzhangkai
 * 2018/11/20 10:43
 * Email: zhangkaiwan@qq.com
 */
public class JavaCourse implements Course {

    private Integer id;
    private String name;
    private BigDecimal price;

    public JavaCourse(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
