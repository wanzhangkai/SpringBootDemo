package com.pipikai.concurrency.example.singleton;

import com.pipikai.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉单例
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2018/11/13 21:07
 */
@Slf4j
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1() {
    }

    //单例对象
    private static SingletonExample1 instance = null;

    //静态的工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }

}
