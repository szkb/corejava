package com.study.basicknowledge.basicjava.finalstudy;

import org.junit.Test;

public class FinalTest {

    private String baseSql = "hello";

    private static final String SQL = "world";

    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }

    @Test
    public void test() {
        baseSql += "world";
        System.out.println(baseSql + "world");
    }

    @Test
    public void test2() {
        StringBuilder stringBuilder = new StringBuilder(SQL);
        stringBuilder.append("world");
        System.out.println(stringBuilder.toString());
    }
}