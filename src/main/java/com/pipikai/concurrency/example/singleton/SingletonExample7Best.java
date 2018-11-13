package com.pipikai.concurrency.example.singleton;

import com.pipikai.concurrency.annotation.Recommend;
import com.pipikai.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 枚举模式单例 - 最安全
 * 推荐使用
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2018/11/13 21:07
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExample7Best {

    //私有构造函数
    private SingletonExample7Best() {
    }

    //静态的工厂方法
    public static SingletonExample7Best getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7Best singleton;

        //JVM来保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7Best();
        }

        public SingletonExample7Best getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
    }

}
