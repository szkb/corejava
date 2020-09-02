package com.study.designmode.singleton;

import java.lang.reflect.Constructor;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/9 16:53
 */
public class VolatileSingleton {

    private VolatileSingleton() {

    }

    private static volatile VolatileSingleton instance = null;

    public static VolatileSingleton getInstance() {
        if (instance == null) {
            synchronized (VolatileSingleton.class) {
                if (instance == null) {
                    instance = new VolatileSingleton();
                }
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

    @Test
    public void test2() throws Exception {
        Class<VolatileSingleton> clazz = VolatileSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        VolatileSingleton a = (VolatileSingleton) constructor.newInstance();
        VolatileSingleton b = (VolatileSingleton) constructor.newInstance();

        System.out.println(a);
        System.out.println(b);

    }

    public static void main(String[] args) throws Exception {
        Class<VolatileSingleton> clazz = VolatileSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        VolatileSingleton a = (VolatileSingleton) constructor.newInstance();
        VolatileSingleton b = (VolatileSingleton) constructor.newInstance();

        System.out.println(a);
        System.out.println(b);
    }

}
