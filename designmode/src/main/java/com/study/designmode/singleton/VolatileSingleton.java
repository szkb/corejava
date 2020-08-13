package com.study.designmode.singleton;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/9 16:53
 */
public class VolatileSingleton {

    private static volatile VolatileSingleton instance = null;

    public static VolatileSingleton getInstance() {
        if (instance == null) {
            synchronized (VolatileSingleton.class) {
                instance = new VolatileSingleton();
            }
        }
        return instance;
    }

    public void write() {
        synchronized (VolatileSingleton.class) {
            System.out.println("hello world");
        }
    }

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> System.out.println(VolatileSingleton.getInstance())).start();
        }
        new Thread(() -> write());
        Thread.sleep(5000);
    }

}
