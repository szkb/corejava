package com.study.basicknowledge.basicjava.interfaceTest.defaulttest;

/**
 * @author hangwu
 * @date 2020/12/6 17:36
 */
public interface A {

    default void hello() {
        System.out.println("hello from A");
    }
}
