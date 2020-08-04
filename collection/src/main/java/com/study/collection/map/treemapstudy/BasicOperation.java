package com.study.collection.map.treemapstudy;

import java.util.TreeMap;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/4 14:30
 */
public class BasicOperation {

    @Test
    public void test() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("2", "2");
        treeMap.put("1", "1");
        treeMap.put("3", "3");

        System.out.println(treeMap.get("1"));
    }

}
