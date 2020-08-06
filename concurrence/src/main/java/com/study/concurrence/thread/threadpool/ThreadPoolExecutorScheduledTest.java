package com.study.concurrence.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorScheduledTest {
    public static void main(String[] args) {
        //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒执行
        scheduledThreadPool.schedule(() -> System.out.println("延迟1秒执行"), 1, TimeUnit.SECONDS);
    }
}