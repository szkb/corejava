package com.study.basicknowledge.nulltest;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/21 19:36
 */
public class NullTest {
    class Student {

    }

    private static String getTask(String name, Student action) {
        String temp = getAction(action);
        return name + temp;
    }

    private static String getAction(Student action) {
        if (action == null) {
            return "hello";
        }
        return "hello " + "action";
    }

    @Test
    public void test() {
        System.out.println(getTask("1", null));

    }

}
