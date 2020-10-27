package test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.cglib.core.AbstractClassGenerator;
import org.springframework.cglib.core.internal.Function;
import org.springframework.util.CollectionUtils;

/**
 * @author hangwu
 * @date 2020/3/24 20:50
 */

class SampleClass {
    public String test(String input) {
        return "Hello World!";
    }
}

public class ExampleTest {

    static class Student {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private Timestamp time;

    private String bookingChannel;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getBookingChannel() {
        return bookingChannel;
    }

    public void setBookingChannel(String bookingChannel) {
        this.bookingChannel = bookingChannel;
    }

    private void work(String name) {
        System.out.println(name + "working");
    }

    @Test
    public void test() {
        ExampleTest exampleTest = new ExampleTest();
        exampleTest.work(getName());
    }

    private String getName() {
        return null;
    }

    @Test
    public void test2() {
        Map<String, Integer> mapReservationBookingChannel = new HashMap<>(0);
        List<String> numberList = new ArrayList<>(0);
//        numberList.forEach(item -> {
//            setMapBookingChannel(item, mapReservationBookingChannel);
//        });
//        System.out.println(mapReservationBookingChannel);

        mapReservationBookingChannel.forEach((s, integer) -> System.out.println("hello"));
    }

    @Test
    public void test3() {
        ExampleTest exampleTest = new ExampleTest();
        exampleTest.setTime(new Timestamp(System.currentTimeMillis()));
        exampleTest.setTime(null);
        long time = Optional.ofNullable(exampleTest).map(ExampleTest::getTime).map(Timestamp::getTime).orElse(0L);
        System.out.println(time);
    }

    @Test
    public void test4() {

        List<ExampleTest> exampleTestList = new ArrayList<>();
        List<ExampleTest> exampleTestList1 = new ArrayList<>(0);

        ExampleTest exampleTest = new ExampleTest();
        exampleTest.setBookingChannel("hello");
        exampleTestList.add(exampleTest);

        ExampleTest exampleTest1 = new ExampleTest();
        exampleTest1.setBookingChannel("hello");
        exampleTestList.add(exampleTest1);

        ExampleTest exampleTest2 = new ExampleTest();
        exampleTest2.setBookingChannel("hello");
        exampleTestList.add(exampleTest2);

        ExampleTest exampleTest3 = new ExampleTest();
        exampleTest3.setBookingChannel("world");
        exampleTestList.add(exampleTest3);

        Map<String, Long> mapBookingChannel = exampleTestList.stream().collect(
            Collectors.groupingBy(ExampleTest::getBookingChannel, Collectors.counting()));
        System.out.println(mapBookingChannel.size());

//        System.out.println(exampleTestList1);
//        mapBookingChannel.forEach(this::print);

    }

    private void print(String key, Long value) {
        System.out.println(key);
        System.out.println(value);
    }

    private void setMapBookingChannel(String number, Map<String, Integer> mapBookingChannel) {
        if (mapBookingChannel.get(number) == null) {
            mapBookingChannel.put(number, 1);
        } else {
            int count = mapBookingChannel.get(number);
            count++;
            mapBookingChannel.put(number, count);
        }
    }

    @Test
    public void test5() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("hello", 1);
        mapList.add(map);
    }

    @Test
    public void test6() {
        Map<String, AtomicInteger> map = new ConcurrentHashMap<>();
        map.put("hello", new AtomicInteger(1));
        map.computeIfAbsent("world", key -> new AtomicInteger()).decrementAndGet();
        System.out.println(map);

        // 这个返回的是一个Map
        Map<String, AtomicInteger> ans =
            map.entrySet().stream().collect(Collectors.toConcurrentMap(Entry::getKey,
                item -> new AtomicInteger(item.getValue().decrementAndGet())));

        System.out.println((ConcurrentHashMap<String, AtomicInteger>) ans );
    }

    @Test
    public void test7() {
        Map<String, AtomicInteger> map = new ConcurrentHashMap<>();
        map.put("hello", new AtomicInteger(1));
//        map.put("world", new AtomicInteger(3));
        System.out.println(map.putIfAbsent("world", new AtomicInteger(5)));
//        map.putIfAbsent("world", new AtomicInteger(5));
        System.out.println(map);
    }

    @Test
    public void testFixedValue() {
        // new 一个 Enhancer 实例
        Enhancer enhancer = new Enhancer();
        // 声明使用的父类是 SampleClass
        enhancer.setSuperclass(SampleClass.class);
        // 设置回调方法 - 回调方法实现为 FixedValue (固定值) .
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib!";
            }
        });
        // 创建 SampleClass 的代理子类实例
        SampleClass proxy = (SampleClass) enhancer.create();
        Assert.assertEquals("Hello cglib!", proxy.test(null));
    }

    @Test
    public void test9() {
       ExampleTest.Student student = new ExampleTest.Student();
        if (student.getClass() instanceof Class) {
            System.out.println("yes");
        }
    }

    @Test
    public void test10() {

        List<String> temp = new ArrayList<>();
        if (CollectionUtils.isEmpty(temp)) {
            System.out.println("hello");
        }

        double a = 0.00000;
        double b = 0.5000000000000;

        System.out.println(Double.compare(a, b));

        List<String> sum = Arrays.asList("2", "2", "3", "4", "5", "1");

        List<String> part = Arrays.asList("1", "2", "3", "4");

        List<String> ans =
        sum.stream().filter(item -> part.stream().anyMatch(p -> p.equalsIgnoreCase(item))).distinct()
            .collect(Collectors.toList());

        System.out.println(ans);
    }

    @Test
    public void test11() throws InterruptedException {
        for (int i = 0; i< 10; i++) {
            new Thread(() -> {
                System.out.println("hello world");
            }).start();
        }
        Thread.sleep(2000);
    }
}
