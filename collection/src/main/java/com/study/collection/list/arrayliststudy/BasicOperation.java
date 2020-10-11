package com.study.collection.list.arrayliststudy;

import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/4 17:29
 */
public class BasicOperation {

    @Test
    public void test() {
        List<Integer> ans = new ArrayList<>();
        ans.add(10);
        ans.add(20);
        ans.add(30);

        System.out.println(ans);

        int m = 1;
        for (Integer obj : ans) {
            ans.remove(obj);
            System.out.println("当前值:" + obj + ",执行次数" + m++);
        }

        System.out.println(ans);
    }

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        int m = 1;
        list.add(1);
        for (Integer obj : list) {
            list.remove(obj);
            System.out.println("当前值:" + obj + ",执行次数" + m++);
        }
    }

    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer item = iterator.next();
            iterator.remove();
            System.out.println(item);
        }

        System.out.println(list);
    }

    @Test
    public void test4() {
        String a = "hello";
        int hashCode = a.hashCode();
    }

}
