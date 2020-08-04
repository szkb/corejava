package com.study.collection.map.hashmapstudy;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/3 19:43
 */
public class ShiftOperation {

    // 实例见这个 https://juejin.im/post/684490375291522253

    @Test
    public void test() {
        System.out.println(7 << 1);
        System.out.println(7 >> 1);
        System.out.println(-7 >> 1);

        System.out.println(7 >> 2);
        System.out.println(-7 >> 2);
        System.out.println(-7 >>> 2);
    }

    @Test
    public void test1() {
        System.out.println(-7 << 2);
        System.out.println(-7 >>> 1);
    }

    @Test
    public void test2() {
        System.out.println(9 >> 67);
    }

    @Test
    public void test3() {
        // ^相同则为0,不同则为1;|有1则为1;&有0则为0
        System.out.println(1 ^ 3);
        System.out.println(1 ^ 1);
    }
}
