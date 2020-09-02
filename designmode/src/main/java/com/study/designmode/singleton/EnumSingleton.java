package com.study.designmode.singleton;

import java.lang.reflect.Constructor;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/31 15:22
 */
public enum EnumSingleton {
    ENUM_SINGLETON_INSTANCE;

    public void eat() {
        System.out.println("I love eating");
    }

    public static void main(String[] args) throws Exception {
        ENUM_SINGLETON_INSTANCE.eat();
//        Class<EnumSingleton> clazz = EnumSingleton.class;
//        Constructor constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//
//        EnumSingleton a = (EnumSingleton) constructor.newInstance();
//        EnumSingleton b = (EnumSingleton) constructor.newInstance();
//
//        System.out.println(a);
//        System.out.println(b);
    }
}
