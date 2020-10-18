package com.study.basicknowledge.basicjava.abstracttest;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/17 17:17
 */
public abstract class AbstractService {

    protected String ans;

    protected String getAns() {
        return "hello";
    }

    protected abstract void generate();

    @Test
    public void test() {
        new ServiceA().generate();
        System.out.println(new ServiceA().ans);

    }
}
