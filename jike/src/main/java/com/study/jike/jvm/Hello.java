package com.study.jike.jvm;

/**
 * @author hangwu
 * @date 2022/2/7 14:58
 */
public class Hello {

    public static void main(String[] args) {
        Integer a = 12;
        Integer s = 24;
        if (a > 0) {
            a = a - 2;
        }
        for (int i = 0; i < 2; i++) {
            s = s + a;
        }
        System.out.println(s);
    }
}
