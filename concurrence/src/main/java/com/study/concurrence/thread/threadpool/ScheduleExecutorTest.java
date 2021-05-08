package com.study.concurrence.thread.threadpool;

import java.util.Date;
import java.util.concurrent.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2021/3/29 10:32
 */
public class ScheduleExecutorTest {

    private static final ScheduledExecutorService DELAY_SCHEDULER = Executors
        .newSingleThreadScheduledExecutor();

    @Test
    public void test() throws InterruptedException {
        DELAY_SCHEDULER.scheduleWithFixedDelay(() -> {
            System.out.println("hello" + "-" + new Date());
        }, 0, 5, TimeUnit.SECONDS);

        Thread.sleep(500000);

    }
}
