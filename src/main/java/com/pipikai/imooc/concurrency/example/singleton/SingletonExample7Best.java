package com.pipikai.imooc.concurrency.example.singleton;

import com.pipikai.imooc.concurrency.annotation.Recommend;
import com.pipikai.imooc.concurrency.annotation.ThreadSafe;
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

    private enum SingletonEnum {
        INSTANCE;

        private SingletonExample7Best singleton;

        //JVM来保证这个方法绝对只调用一次
        SingletonEnum() {
            singleton = new SingletonExample7Best();
        }

        public SingletonExample7Best getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        System.out.println(SingletonEnum.INSTANCE.getInstance().hashCode());
    }

}
