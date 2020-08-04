package com.study.collection.list.arrayliststudy;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/4 17:29
 */
public class BasicOperation {

    @Test
    public void test() {
        List<String> ans = new ArrayList<>();
        ans.add("hello");
        ans.add("world");

        System.out.println(ans.get(0));
    }

}
