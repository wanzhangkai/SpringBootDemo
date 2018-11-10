package com.pipikai.concurrency.example;

import com.pipikai.concurrency.annotation.NotThreadSafe;
import com.pipikai.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 代码模拟并发：
 * CountDownLatch 和 Semaphore的使用
 * 使用volatile,不安全
 *
 * @Author: wanzhangkai
 * @Email: zhangkaiwan@qq.com
 * @Date: 2018/11/9 21:37
 */
@Slf4j
@NotThreadSafe
public class CountExample4 {

    public static int clientTolal = 5000;

    public static int threadTotal = 200;

    public static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTolal);
        for (int i = 0; i < clientTolal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        //因为count++不是原子操作（分了3小步执行：读count，+1，写count），volatile只能保证count可见而无法保证+1同步。
        count++;
    }

}
