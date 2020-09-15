package com.study.concurrence.queue;

import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/14 20:28
 */
public class LinkedBlockingQueueTest {

    @Test
    public void test() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("hello");
        queue.add("world");
        System.out.println(queue);
    }
}
