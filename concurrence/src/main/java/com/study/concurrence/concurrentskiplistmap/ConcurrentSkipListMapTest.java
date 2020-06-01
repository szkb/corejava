package com.study.concurrence.concurrentskiplistmap;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/5/4 22:32
 */
public class ConcurrentSkipListMapTest {

    @Test
    public void test() {
//        ConcurrentSkipListMap<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
//        concurrentSkipListMap.put("1", "hello");
//        System.out.println(concurrentSkipListMap);

        HashMap<String, String> concurrentHashMap = new HashMap<>();
        concurrentHashMap.put("1", "hello");
        concurrentHashMap.put("3", "world");
        concurrentHashMap.put("2", "hello world");
        concurrentHashMap.put("4", "hello");
        concurrentHashMap.put("5", "world");
        concurrentHashMap.put("6", "hello world");
        System.out.println(concurrentHashMap);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            test();
        }
    }

    @Test
    public void test3() {
        long time = 0;
        System.out.println(time);
    }

    @Test
    public void test4() {
        Student student = new Student();
        long ans = Optional.ofNullable(student).map(Student::getId).orElse(0L);
        System.out.println(student.getId());
        System.out.println(ans);
    }

    class Student {
        private Long id;

        Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

}
