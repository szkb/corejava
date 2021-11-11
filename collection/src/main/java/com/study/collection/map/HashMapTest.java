package com.study.collection.map;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/5/13 15:32
 */
public class HashMapTest {

    class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void test() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        //只对map中存在的key对应的value进行操作
        Integer integer = map.computeIfPresent("3", (k, v) -> v + 1);
        Integer integer1 = map.computeIfPresent("4", (k, v) -> {
            if (v == null) {
                return 3;
            }
            return v + 1;
        });
        System.out.println(integer);
        System.out.println(integer1);
        System.out.println(map.toString());
    }

    @Test
    public void test2() {

        ConcurrentHashMap<Integer, ConcurrentHashMap<String, Integer>> resultMap = new ConcurrentHashMap<>();
        List<ConcurrentHashMap<String, Integer>> ansMap = new ArrayList<>();
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        ansMap.add(map);
        resultMap.put(0, map);

        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.put("4", 4);
        map2.put("5", 5);
        map2.put("6", 6);
        ansMap.add(map2);
        resultMap.put(0, map2);

        ConcurrentHashMap<String, Integer> result = ansMap.stream()
            .filter(stringIntegerMap -> stringIntegerMap.containsKey("5")).findFirst().orElse(new ConcurrentHashMap<>());
        System.out.println(result);

        ConcurrentHashMap<String, Integer> result2 = resultMap.values().stream()
            .filter(stringIntegerMap -> stringIntegerMap.containsKey("5")).findFirst().orElse(new ConcurrentHashMap<>());
        System.out.println(result2);
    }

    @Test
    public void test3() {
        String bookingChannel = "GDS-WS";
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        ConcurrentHashMap<String, AtomicInteger> entry = new ConcurrentHashMap<>();
        entry.put(bookingChannel ,atomicInteger);
        if (entry.contains(bookingChannel)) {
            System.out.println("hello world");
        }
    }

    @Test
    public void test4() {
        ConcurrentHashMap<String, Integer> reservationBookingChannelMap= new ConcurrentHashMap<>();
        reservationBookingChannelMap.put("hello", 0);
        reservationBookingChannelMap.put("world", 1);
        Map<String, Integer> ans =
            reservationBookingChannelMap.entrySet().stream().filter(e -> checkValue(e.getValue())).collect(Collectors.toMap(
                Entry::getKey, Entry::getValue));
        System.out.println(ans);

    }

    private boolean checkValue(Integer value) {
        return value != 0;
    }

    @Test
    public void test5() {
        HashMap<Integer, String> hosting = new HashMap<>();
        hosting.put(1, "linode.com");
        hosting.put(2, "heroku.com");
        hosting.put(3, "digitalocean.com");
        hosting.put(4, "aws.amazon.com");
        //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect = hosting.entrySet().stream()
            .filter(map -> map.getKey() == 2)
            .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        System.out.println(collect); //output : {2=heroku.com}
    }

    @Test
    public void test6() {
        ConcurrentHashMap<String, AtomicInteger> temp = new ConcurrentHashMap<>(0);
        temp.clear();
        temp.computeIfAbsent("bookingChannel", key -> new AtomicInteger())
            .incrementAndGet();
        System.out.println(temp);
    }

    @Test
    public void test7() {
        List<String> numberList = new ArrayList<>();
        numberList.add("hello");

        if (numberList.contains(null)) {
            System.out.println("hello world");
        }
    }

    @Test
    public void test8() {
        List<String> numberList = new ArrayList<>();
        numberList.add("hello");
        numberList.add("world");

        List<String> numberList2 = new ArrayList<>();
        numberList2.add("hello");
        numberList2.add(null);

        System.out.println(numberList.retainAll(numberList2));
        System.out.println(numberList);
        System.out.println(numberList2);
    }

    @Test
    public void test9() {
       Set<Integer> ans = new HashSet<>();
       ans.add(2);
       ans.add(1);
       System.out.println(ans);
    }

    @Test
    public void test10() {
        boolean a = false;
        boolean b = false;
        System.out.println(a ^ b);

        a = true;
        b = true;
        System.out.println(a ^ b);

        a = false;
        b = true;
        System.out.println(a ^ b);
    }

    @Test
    public void test11() {
        List<String> ans = new ArrayList<>();
        ans.add("hello");
        ans.add("world");

        List<String> number = new ArrayList<>();
        number.add("1");
        number.add("2");

        number.addAll(ans);
        System.out.println(number);

        number.addAll(0, ans);
        System.out.println(number);
    }

    @Test
    public void test12() {
        List<String> ans = new ArrayList<>();
        ans.add("hello");
        System.out.println(ans);

        ans.add("你好");
        System.out.println(ans);
    }

    @Test
    public void test13() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("123");
        users.add(user);

        List<User> ans = new ArrayList<>(users);
        System.out.println(ans);
        System.out.println(users);

        users.get(0).setName("hello");
        System.out.println(ans);
        System.out.println(users);
    }
}
