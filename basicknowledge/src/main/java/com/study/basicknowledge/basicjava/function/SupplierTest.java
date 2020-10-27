package com.study.basicknowledge.basicjava.function;

import java.util.function.Supplier;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/10/27 17:44
 */
public class SupplierTest {

    @Test
    public void test() {
        String ans = getOrAdd(SupplierTest::getName, 1, "hello");
    }

    private <T> T getOrAdd(Supplier<T> getName, int i, String hello) {
        return getOrAdd((k, v) -> getName.get(), hello);
    }

    private <T> T getOrAdd(CacheItemRefreshAction refreshAction, String hello) {
        return null;
    }

    private static String getName() {
        return "world";
    }
}
