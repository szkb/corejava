package com.study.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/7/30 17:32
 */
public class LinkedHashMapTest {

    /**
     * 默认插入顺序排序
     */
    @Test
    public void test() {
        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>(2);
        linkedMap.put("2", "2");
        linkedMap.put("1", "1");
        linkedMap.put("3", "3");

        linkedMap.put("2", "3");

        System.out.println(linkedMap);
        for (Map.Entry<String, String> map : linkedMap.entrySet()) {
            System.out.println(map);
        }
    }

    @Test
    public void test2() {
        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>(10, 0.75f, true);
        linkedMap.put("2", "2");
        linkedMap.put("1", "1");
        linkedMap.put("3", "3");

        linkedMap.put("2", "3");

        System.out.println(linkedMap);
    }

}
