package com.study.collection.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> linkedMap=new TreeMap<>(
                new Comparator<Integer>() {//与key类型对齐
                    @Override//根据参数o1与参数o2比较大小返回正、0、负，小的在前边；
                    public int compare(Integer o1, Integer o2) {
                        return Math.abs(o1-2)-Math.abs(o2-2);
                    }
                }
        );
        linkedMap.put(1,"du");
        linkedMap.put(2,"gen");
        linkedMap.put(3,"kui");//因为根据自定义的比较类，3和1在逻辑上是大小的（距离2）,因此会覆盖（1，“du");
        linkedMap.put(1,"gen");
        System.out.println(linkedMap);//输出顺序为从小到大
    }
}