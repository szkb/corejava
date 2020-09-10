package com.study.basicknowledge.projecttest;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/8 15:33
 */
public class Example {

    @Test
    public void test() {
        List<String> temp = Arrays.asList("hello", "world");
        List<String> ans = temp;

        ans = Arrays.asList("hello");

        System.out.println(temp);
        System.out.println(ans);
    }

    @Test
    public void test2() {
        List<String> temp = new ArrayList<>();
        temp.add("hello");
        List<String> ans = new ArrayList<>(temp);

        ans.add("world");

        System.out.println(temp);
        System.out.println(ans);
    }

}
