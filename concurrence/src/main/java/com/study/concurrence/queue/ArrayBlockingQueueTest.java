package com.study.concurrence.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/11 21:15
 */
public class ArrayBlockingQueueTest {

    @Test
    public void test() {
        // ArrayBlockingQueue源码阅读
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        queue.add("hello");
        queue.add("world");
        System.out.println(queue);
    }


}
