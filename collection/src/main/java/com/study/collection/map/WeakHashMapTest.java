package com.study.collection.map;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/6/3 14:59
 */
public class WeakHashMapTest {

    @Test
    public void test() {
        String a = new String("a");
        String b = new String("b");
        Map weakmap = new WeakHashMap();
        Map map = new HashMap();
        map.put(a, "aaa");
        map.put(b, "bbb");


        weakmap.put(a, "aaa");
        weakmap.put(b, "bbb");

        map.remove(a);

        a=null;
        b=null;

        System.gc();
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry en = (Map.Entry)i.next();
            System.out.println("map:"+en.getKey()+":"+en.getValue());
        }

        Iterator j = weakmap.entrySet().iterator();
        while (j.hasNext()) {
            Map.Entry en = (Map.Entry)j.next();
            System.out.println("weakmap:"+en.getKey()+":"+en.getValue());

        }
    }

    @Test
    public void test2() {
        Map weakHashMap = new WeakHashMap();
        Map hashMap = new HashMap();
        String a = new String("1");
        weakHashMap.put(a, "hello world");
        hashMap.put(a, "hello world");

        a = null;
        System.gc();

        for (Object o : weakHashMap.entrySet()) {
            Map.Entry en = (Map.Entry) o;
            System.out.println("weakmap:" + en.getKey() + ":" + en.getValue());
        }

        for (Object o : hashMap.entrySet()) {
            Map.Entry en = (Map.Entry) o;
            System.out.println("map:" + en.getKey() + ":" + en.getValue());
        }
    }

}
