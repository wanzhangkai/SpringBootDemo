package com.pipikai.imooc.concurrency.example.singleton;

import com.pipikai.imooc.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉单例 - 双重同步锁单例模式
 * volatile + 双重检测 = 懒汉安全
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2018/11/13 21:07
 */
@Slf4j
@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5() {
    }

    //单例对象 -加volatile来禁止JVM或cpu的指令重排序带来的线程不安全
    private volatile static SingletonExample5 instance = null;

    //1、memory = allocate() 分配对象的内存空间
    //2、ctorInstance() 初始化对象
    //3、instance = memory 设置instance指向刚分配的内存

    //静态的工厂方法
    public static SingletonExample5 getInstance() {
        if (instance == null) { //双重检测机制
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }

}
