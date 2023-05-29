package com.study.offer.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2022/12/1 14:43
 */
public class ExampleTest {

    private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // Becomes 1 if any 1 bits are shifted off
        while (n >= 32) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    @Test
    public void test() {
        System.out.println(minRunLength(64));
    }

    @Test
    public void test2() {
        List<Integer> ans = new ArrayList<>();
        ans.add(3);
        ans.add(3);
        ans.add(4);
        System.out.println(ans.size());

        System.out.println(ans.stream().collect(Collectors.toSet()).size());
    }

    @Test
    public void test3() {
//        List<Integer> ans = Collections.emptyList();
//        ans.add(1);
//        System.out.println(ans);

        Set<Integer> hello = new HashSet<>();
        System.out.println(hello.contains(null));

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.putIfAbsent(123, 456));
        System.out.println(map.putIfAbsent(123, 789));

        System.out.println(map.computeIfAbsent(124, k -> 456));
        System.out.println(map.computeIfAbsent(124, k -> 12));
        System.out.println(map);
    }

}
