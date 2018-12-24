package com.pipikai.imooc.design.principle.openclose;

import java.math.BigDecimal;

/**
 * Created by wanzhangkai
 * 2018/11/20 11:01
 * Email: zhangkaiwan@qq.com
 */
public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, BigDecimal price) {
        super(id, name, price);
    }

    public BigDecimal getOriginPrice() {
        return super.getPrice();
    }

    public BigDecimal getPrice() {
        return super.getPrice().multiply(new BigDecimal("0.8"));
    }

}
