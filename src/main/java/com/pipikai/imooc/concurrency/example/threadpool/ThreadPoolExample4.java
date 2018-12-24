package com.pipikai.imooc.concurrency.example.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanzhangkai
 * 2018/12/21 10:34
 * Email: zhangkaiwan@qq.com
 */
@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);


        executorService.schedule(() -> log.info("schedule run"), 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> log.info("scheduleAtFixedRate run"), 1, 3, TimeUnit.SECONDS);

        executorService.shutdown();

        //Timer example,类似Executors.newScheduledThreadPool(1)
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5 * 1000);
    }

}
