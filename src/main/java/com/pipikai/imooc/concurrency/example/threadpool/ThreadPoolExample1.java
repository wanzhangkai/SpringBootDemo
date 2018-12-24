package com.pipikai.imooc.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanzhangkai
 * 2018/12/21 10:34
 * Email: zhangkaiwan@qq.com
 */
@Slf4j
public class ThreadPoolExample1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> log.info("task:{}", index));
        }
        executorService.shutdown();
    }

}
