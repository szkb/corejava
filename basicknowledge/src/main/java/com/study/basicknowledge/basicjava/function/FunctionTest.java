package com.study.basicknowledge.basicjava.function;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/10/20 19:17
 */
public class FunctionTest {
    private Function<String, String> convertor;

    @Test
    public void test() {
        convertor = 1 == 0 ? String::toUpperCase : String::new;
        System.out.println(this.convertor.apply("hello"));
    }

    @Test
    public void test2() {
        Set<String> ans = new HashSet<>();
        ans.add("hello");
        ans.add("HELLO");
        ans.add("hello");
        System.out.println(ans);
    }
}
