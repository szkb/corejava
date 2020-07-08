package com.study.basicknowledge.callback;

import java.util.function.Consumer;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/7/2 11:43
 */
public class Printer {

    @Test
    public void test() throws InterruptedException {
        sprint("hello", this::executionAsync);
    }

    private void sprint(String hello, AsyncCallback<String> callback) throws InterruptedException {
        System.out.println(hello);
        Thread.sleep(1000);
        callback.execute("1");

    }

    private void executionAsync(String ans) throws InterruptedException {
        System.out.println(ans);
    }

    @Test
    public void test2() {
        runConsumer("hello", ans -> {
            System.out.println(ans);
            System.out.println(1);
        });
    }

    private void runConsumer(String hello, Consumer<String> consumer) {
        System.out.println(hello);
        consumer.accept("world");
    }
}
