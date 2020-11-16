package com.study.basicknowledge.basicjava.stream.reduce;

import java.util.*;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/11/14 11:51
 */
public class ReduceTest {

    @Test
    public void test() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        int result = numList.stream().reduce(Integer::sum).get();
        System.out.println(result);
    }

    @Test
    public void test2() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);
        int result = numList.stream().reduce(10, Integer::sum);
        System.out.println(result);
    }

    @Test
    public void test3() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<String> result = numList.stream().reduce(new ArrayList<String>(), (a, b) -> {
            a.add("element-" + b);
            return a;
        }, (a, b) -> new ArrayList<>(b));
        System.out.println(result);
    }

    @Test
    public void test4() {

    }
}
