package com.study.concurrence;

import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.springframework.util.StringUtils;

/**
 * @author hangwu
 * @date 2022/9/5 15:44
 */
public class RateLimiterTest {

    @Test
    public void testSmoothBursty3() {
        RateLimiter r = RateLimiter.create(5);
        while (true)
        {
            System.out.println("get 5 tokens: " + r.acquire(5) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
            /**
             * output:
             * get 5 tokens: 0.0s
             * get 1 tokens: 0.996766s 滞后效应，需要替前一个请求进行等待
             * get 1 tokens: 0.194007s
             * get 1 tokens: 0.196267s
             * end
             * get 5 tokens: 0.195756s
             * get 1 tokens: 0.995625s 滞后效应，需要替前一个请求进行等待
             * get 1 tokens: 0.194603s
             * get 1 tokens: 0.196866s
             */
        }
    }

    @Test
    public void test() {
        RateLimiter r = RateLimiter.create(2);
        while (true) {
            r.acquire();
            System.out.println("hello world");
        }
    }

    @Test
    public void testAcquire() {
        RateLimiter limiter = RateLimiter.create(1);
        for(int i = 1; i < 10; i = i + 2 ) {
            double waitTime = limiter.acquire(10);
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
//        for (int i = 10; i > 0; i = i - 2) {
//            double waitTime = limiter.acquire(i);
//            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
//        }
    }

    @Test
    public void test11() {
        String a = null;
        System.out.println("b".equals(a));
    }

    @Test
    public void test12() {
        String filterValue = "1000|2000";
        String[] filter = StringUtils.split(filterValue, "|");
        System.out.println(filter[0]);
        System.out.println(filter[1]);
        System.out.println(ArrayUtils.getLength(null));
    }

}
