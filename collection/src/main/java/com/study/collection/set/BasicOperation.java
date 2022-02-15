package com.study.collection.set;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/4 17:45
 */
public class BasicOperation {

    @Test
    public void test() {
        Set<String> ans = new HashSet<>();
        ans.add("hello");
        ans.add("world");

        for (String an : ans) {
            System.out.println(an);
        }
    }

    @Test
    public void test2() {
        Set<String> ans = new LinkedHashSet<>();
        ans.add("hello");
        ans.add("world");

        Iterator<String> iterator = ans.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        Set<String> ans = new TreeSet<>();
        ans.add("2");
        ans.add("1");

        Iterator<String> iterator = ans.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4() {
        List<String> ans = new ArrayList<>();
        ans.add("2");
        ans.add("1");

        Set<String> set = ans.stream().collect(Collectors.toSet());
        System.out.println(set.contains(null));
    }
}
