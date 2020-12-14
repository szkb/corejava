package com.study.basicknowledge.basicjava.interfaceTest.defaulttest;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/12/6 17:37
 */
public class C extends D implements A, B {

    @Test
    public void test() {
        hello();
    }

}
