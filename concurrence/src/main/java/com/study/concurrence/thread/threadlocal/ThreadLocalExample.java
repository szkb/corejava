package com.study.concurrence.thread.threadlocal;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2021/5/13 15:30
 */
public class ThreadLocalExample {

    public static void main(String[] args) {
        String temp = "hello";
        String finalTemp = temp;
        System.out.println(finalTemp);
        new Thread(() -> {
            ThreadLocal<String> temp2 = new ThreadLocal<>();
            temp2.set(finalTemp);
            System.out.println(finalTemp);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(temp2.get());
        }).start();
        temp = "world";
        System.out.println(temp);
    }

    @Test
    public void test() {
        String temp = "hello";
        String finalTemp = temp;
        System.out.println(finalTemp);
        temp = "world";
        System.out.println(finalTemp);
        System.out.println(temp);
    }

}
