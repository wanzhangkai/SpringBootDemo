package com.pipikai.concurrency.atomic;

import com.pipikai.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicIntegerFieldUpdater类的使用
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2018/11/10 11:34
 */
@Slf4j
@ThreadSafe
public class AtomicExample2 {

    private static AtomicIntegerFieldUpdater<AtomicExample2> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample2.class, "count");

    @Getter
    public volatile int count = 100;  //必须要非static字段

    public static void main(String[] args) {
        AtomicExample2 atomicExample2 = new AtomicExample2();
        if (updater.compareAndSet(atomicExample2, 100, 120)) {
            log.info("update success 1, {}", atomicExample2.getCount());
        }

        if (updater.compareAndSet(atomicExample2, 120, 200)) {
            log.info("update success 2, {}", atomicExample2.getCount());
        } else {
            log.info("update failed, {}", atomicExample2.getCount());
        }
    }

}
