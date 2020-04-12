package com.study.basicknowledge.time;

import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/1 13:47
 */
public class TimeUnitTest {

    @Test
    public void test() {
        long time = 1;
        System.out.println(TimeUnit.MINUTES.toMillis(time));
    }

    @Test
    public void test2() {

    }

}
