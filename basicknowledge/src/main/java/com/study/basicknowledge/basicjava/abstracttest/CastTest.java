package com.study.basicknowledge.basicjava.abstracttest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/10/16 13:54
 */
@Slf4j
public class CastTest {

    public static void main(String[] args) {
        String a = "hello";
        int b = 2;
        int c = 100;
        boolean ans = "11".equals(a) && b < 2 && c > 100 || c > 2;
        System.out.println(ans);
    }

    @Test
    public void test() {
        String a = null;
        System.out.println("hello" != (a));
        System.out.println(a != "hello");
    }

    @Test
    public void test2() {
        Set<String> a = new HashSet<>();
        a.add("111");
        a.add("world");

        Set<String> b = new HashSet<>();
        b.add("111");
        b.add("uu");

        System.out.println(CollectionUtils.containsAny(a, b));
    }

    @Test
    public void test3() {
        HashSet<String> result = new HashSet<>();
        result.add("hello");
        result.add("world");
        HashSet<String> productInfoSet = new HashSet<>();
        productInfoSet.add("HELLO");
        productInfoSet.add("WORLD");
        productInfoSet.add("123");
        result.retainAll(productInfoSet);
        System.out.println(result);
    }

    @Test
    public void test4() {
        BigDecimal a = new BigDecimal(-17);
        System.out.println(a.divide(new BigDecimal(4), BigDecimal.ROUND_CEILING));
    }

    @Test
    public void test5() {
        String a = "hello";
        try {
            System.out.println(Integer.parseInt(a) / 0);
        } catch (ArithmeticException e) {
            System.out.println("hello world");
        } catch (Error e) {
            log.error("throwable", e);
            System.out.println("hello");
        }
    }

    @Test
    public void test6() {
        Set<String> ans = new HashSet<>();
        ans.add("hello");
        System.out.println(ans.contains(null));
    }

    @Test
    public void test7() {
        List<String> ans = new ArrayList<>();
        ans.add("2");
        ans.add("3");
        ans.add("2");
        List<String> result = ans.stream().filter(item -> "2".equals(item)).collect(Collectors.toList());
        System.out.println(result);
    }
}
