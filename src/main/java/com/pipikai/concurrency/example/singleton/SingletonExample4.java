package com.pipikai.concurrency.example.singleton;

import com.pipikai.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉单例 - 双重同步锁单例模式
 * 注意它是线程不安全的
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2018/11/13 21:07
 */
@Slf4j
@NotThreadSafe
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4() {
    }

    //单例对象
    private static SingletonExample4 instance = null;

    //1、memory = allocate() 分配对象的内存空间
    //2、ctorInstance() 初始化对象
    //3、instance = memory 设置instance指向刚分配的内存
    //若JVM 和cpu优化发生了指令重排，则在多线程中不安全

    //静态的工厂方法
    public static SingletonExample4 getInstance() {
        if (instance == null) { //双重检测机制
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }

}
