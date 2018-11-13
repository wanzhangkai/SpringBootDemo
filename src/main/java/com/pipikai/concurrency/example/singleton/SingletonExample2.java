package com.pipikai.concurrency.example.singleton;

import com.pipikai.concurrency.annotation.NotThreadSafe;
import com.pipikai.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉单例
 * 加载慢但是安全
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2018/11/13 21:07
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2() {
    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }

}
