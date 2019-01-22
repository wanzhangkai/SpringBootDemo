package com.pipikai.imooc.concurrency.example.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 最佳单例
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2019/1/22 16:13
 */
@Slf4j
public enum SingletonEnum {
    INSTANCE;

    private Singleton singleton;

    SingletonEnum() {
        this.singleton = new Singleton();
    }

    Singleton getInstance() {
        return singleton;
    }

    private class Singleton {
        //something
    }

    public static void main(String[] args) {
        System.out.println(SingletonEnum.INSTANCE.getInstance());
    }

}
