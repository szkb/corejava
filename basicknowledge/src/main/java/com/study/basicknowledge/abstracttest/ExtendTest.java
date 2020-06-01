package com.study.basicknowledge.abstracttest;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/17 17:17
 */
public class ExtendTest extends AbstractService{

    private void eat() {
        System.out.println("hello");
    }

    @Test
    public void test() {
        ExtendTest extendTest = new ExtendTest();
        System.out.println(extendTest.ans);
        System.out.println(extendTest.getAns());
    }

    @Test
    public void test2() {
        ExtendTest service = new ExtendTest();
        service.getAns();
    }

}
