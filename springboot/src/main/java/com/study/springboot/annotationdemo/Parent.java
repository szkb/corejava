package com.study.springboot.annotationdemo;

/**
 * @author hangwu
 * @date 2020/3/11 19:29
 */
public interface Parent {

    void eat();

    default boolean getValue() {
        return true;
    }
}
