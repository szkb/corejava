package com.study.basicknowledge.basicjava.abstracttest;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/17 17:17
 */
public class ExtendTest extends AbstractService{

    private void eat() {
        System.out.println("hello");
    }

    @Override
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

    @Override
    protected void generate() {
        generate();
        this.ans = "hello";
    }

    public static void main(String[] args) {
        System.out.println(new ServiceA().ans);
        System.out.println(new ServiceB().ans);
    }
}
