package com.study.collection.map.hashmapstudy;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/3 19:44
 */
public class BasicFunction {

    @Test
    public void test() {
        // 测试put和resize
        Map<String, String> ans = new HashMap<>();
        ans.put("1", "1");
        ans.put("2", "2");

        for (int i = 3; i < 20; i++) {
            ans.put(String.valueOf(i), String.valueOf(i));
        }
        System.out.println(ans);
    }

    @Test
    public void test1() {
        // 测试get
        Map<String, String> ans = new HashMap<>();
        ans.put("1", "1");
        ans.put("2", "2");

        System.out.println(ans.get("1"));
    }
}
