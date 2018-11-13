package com.pipikai.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;

/**
 * 逸出举例:
 * this会多启用一个线程让其属性可见
 * 对象未完成构造之前不允许发布
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2018/11/13 20:49
 */
@Slf4j
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }

    }

    public static void main(String[] args) {
        new Escape();
    }

}
