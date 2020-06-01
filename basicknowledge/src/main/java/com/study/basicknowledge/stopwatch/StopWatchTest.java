package com.study.basicknowledge.stopwatch;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/26 11:37
 */
public class StopWatchTest {

    @Test
    public void test() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Thread.sleep(2000);
        System.out.println(stopWatch.getTime());
    }
}
