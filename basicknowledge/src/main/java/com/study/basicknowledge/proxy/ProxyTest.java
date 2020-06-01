package com.study.basicknowledge.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/5/20 20:00
 */
public class ProxyTest {

    private static final Class<?>[] constructorParams = { InvocationHandler.class };

    @Test
    public void test() throws NoSuchMethodException {

        final Constructor<?> cons = ProxyTest.class.getConstructor(constructorParams);
        System.out.println(cons);
    }
}
