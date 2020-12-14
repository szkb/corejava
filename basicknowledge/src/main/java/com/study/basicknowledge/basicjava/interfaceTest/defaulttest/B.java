package com.study.basicknowledge.basicjava.interfaceTest.defaulttest;

/**
 * @author hangwu
 * @date 2020/12/6 17:37
 */
public interface B extends A {

    default void hello() {
        System.out.println("hello from B");
    }
}
