package com.study.basicknowledge.basicjava.interfaceTest;

/**
 * @author hangwu
 * @date 2020/3/11 19:29
 */
public interface Parent {

    void eat();

    default void drink() {
        System.out.println("dad is drinking");
    }

}
