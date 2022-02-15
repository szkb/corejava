package com.study.concurrence.listenablefuture;

/**
 * @author hangwu
 * @date 2022/2/9 20:36
 */
public class CallBackExample {

    public static void main(String[] args) throws InterruptedException {
        doWhile();
        System.out.println("hello");
    }

    private static void doWhile() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(30000);
        }
    }

}
