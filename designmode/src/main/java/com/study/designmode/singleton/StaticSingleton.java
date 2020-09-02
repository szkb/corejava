package com.study.designmode.singleton;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/31 15:18
 */
public class StaticSingleton {

    private static class LazyHolder {
        private static final StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return LazyHolder.instance;
    }

    @Test
    public void test() {
        System.out.println(StaticSingleton.getInstance());
        System.out.println(StaticSingleton.getInstance());
    }

}
