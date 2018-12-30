package com.pipikai.imooc.concurrency.example.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * 简单的死锁例子
 * Created by wanzhangkai
 * 2018/12/30 22:42
 * Email: zhangkaiwan@qq.com
 */
@Slf4j
public class DeadLockExample implements Runnable {

    public int flag = 1;

    private static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        log.info("flag:{}", flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    log.info("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    log.info("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLockExample dt1 = new DeadLockExample();
        DeadLockExample dt2 = new DeadLockExample();
        dt1.flag = 1;
        dt2.flag = 0;
        new Thread(dt1).start();
        new Thread(dt2).start();
    }

}
