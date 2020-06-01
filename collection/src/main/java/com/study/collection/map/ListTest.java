package com.study.collection.map;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/5/13 19:42
 */
public class ListTest {

    @Test
    public void test() {
        List<String> ans = new ArrayList<>();
        ans.add("hello");
        ans.add("world");
        String result = ans.stream().filter("hello"::equals).findFirst().orElse(null);
        System.out.println(result);
    }

}
