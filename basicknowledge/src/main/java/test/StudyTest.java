package test;

import com.study.basicknowledge.basicjava.limit.Teacher;
import com.study.basicknowledge.basicjava.stream.reduce.ReduceBenchMark.User;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/11/16 14:12
 */
public class StudyTest {

    private static float[] pickTopKByHeapSort(float a[], int k) {
        int n = a.length;
        PriorityQueue<Float> queue = new PriorityQueue<>(n);
        for (int i = 0; i < k; i++) {
            queue.offer(a[i]);
        }

        for (int i = k; i < n; i++) {
            if (a[i] > queue.peek()) {
                queue.poll();
                queue.offer(a[i]);
            }
        }

        float[] r = new float[k];
        for (int i = k - 1; i >= 0; i--) {
            r[i] = queue.poll();
        }
        return r;
    }

    @Test
    public void test0() {
        System.out.println(Math.floor(0.3333));
        System.out.println(Math.pow(2.5, 3));
    }

    @Test
    public void test2() {
        long time = System.currentTimeMillis();
        long ans = time + TimeUnit.HOURS.toMillis(10);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        System.out.println(TimeUnit.HOURS.toMillis(1));
    }

    @Test
    public void test4() {
        List<User> ans = new ArrayList<>();
        List<User> temp1 = new ArrayList<>();
        User user = new User("kobe", 27, null);
        temp1.add(user);
        Map<String, String> map = new HashMap<>();
        map.put("hello", "1");
        user.setTag(map);

        List<User> temp2 = new ArrayList<>();
        User user2 = new User("jordan", 26, null);
        temp2.add(user2);

        List<User> temp3 = new ArrayList<>();
        User user3 = new User("west", 30, null);
        temp3.add(user3);

        ans.addAll(temp1);
        ans.addAll(temp2);
        ans.addAll(temp3);

        ans.stream().sorted(Comparator.comparing(User::getAge)).filter(user1 -> !user1.getTag().containsKey("hello"))
            .limit(2).forEach(user1 -> user1.getTag().put("11", "17"));

        System.out.println(ans);
    }

    @Test
    public void test5() {
        List<BigDecimal> ans = new ArrayList<>();
        ans.add(BigDecimal.ONE);
        ans.add(null);
        System.out.println(ans.stream().filter(Objects::nonNull).mapToDouble(BigDecimal::doubleValue).sum());
    }

    @Test
    public void test6() {
        long time = System.currentTimeMillis();
        long date = 86400000L;
    }

    @Test
    public void test7() {
        long time = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DATE));

    }

    @Test
    public void test8() {
        System.out.println("begin");
        Map<String, Integer> map = new ConcurrentHashMap<>(16);

        map.computeIfAbsent("AaAa", key -> map.computeIfAbsent("BBBB", key2 -> 42));

        System.out.println("end");
    }

    static final int HASH_BITS = 0x7fffffff;

    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

    @Test
    public void test9() {
        System.out.println(spread("BBBB".hashCode()));
        System.out.println(spread("AaAa".hashCode()));
    }

    @Test
    public void test10() {
        Int2ObjectMap<String> map = new Int2ObjectOpenHashMap<>();
        map.put(1, "hello");
        System.out.println(map);
    }

    @Test
    public void test11() {
        BigDecimal temp = BigDecimal.ONE;
        System.out.println((temp.doubleValue() * 135 - 20) / 100);
    }

    @Test
    public void test12() {
        User user = new User("a", 12, null);
        User user1 = user;
        Map<User, Integer> map = new HashMap<>();
        map.put(new User(), 1);
        map.put(new User(), 2);
        map.put(user, 3);
        map.put(user1, 4);
        System.out.println(map);
    }

    @Test
    public void test13() {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);

        List<Integer> ans1 = new ArrayList<>();
        ans1.add(1);
        ans1.add(2);

        System.out.println(ans.removeAll(ans1));

        System.out.println(ans);
    }

    @Test
    public void test14() {
        long temp = 0x0001L;
        System.out.println(11 & temp);
    }

    @Test
    public void test15() {
        float[] a = {3, 2, 5, 7, 9, 1};
        int n = 3;
        pickTopKByHeapSort(a, n);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test16() {
        Comparator comparator = Comparator.nullsFirst(Comparator.naturalOrder());

        String a = "2";
        String b = "1";

        List<String> ans = new ArrayList<>();
        ans.add(a);
        ans.add(b);

//        comparator1.reversed();
        ans.sort(null);

        System.out.println(ans);
    }

    @Test
    public void test17() {
//        Predicate predicate = o -> false;
//        Predicate predicate1 = o -> true;
//        System.out.println(predicate1.and(predicate).test("hello"));
//
//        Consumer consumer = o -> System.out.println("hello");
//        Consumer consumer1 = o -> System.out.println("world");
//        consumer.andThen(consumer1).accept("1");

        Function<Integer, String> function = i -> "world";
        System.out.println(Function.identity().apply("hello"));

        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
    }

    @Test
    public void test18() {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }

    @Test
    public void test19() {
        String[] ans = new String[]{"hello", "world"};
        System.out.println(Arrays.stream(ans).map(word -> word.split("")).flatMap(Arrays::stream).distinct()
            .collect(Collectors.toList()));
    }

    @Test
    public void test20() {
        List<Integer> ans = Arrays.asList(1, 3, 6, 2);
        Optional<Integer> max = ans.stream().reduce(Integer::max);

        System.out.println(max.get());
    }

    @Test
    public void test21() {
        Stream<int[]> pythagoreanTriples =
            IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                    IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        pythagoreanTriples.limit(5)
            .forEach(t ->
                System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    @Test
    public void test22() {
        List<Integer> title = Arrays.asList(1, 0, 3);
        title.stream().map(number -> 1 / number).collect(Collectors.toList());
    }

    @Test
    public void test23() {
        List<String> ans = new ArrayList<>();
        if (CollectionUtils.isEmpty(ans)) {
            System.out.println("hello");
        }

        ans.add(null);
        if (CollectionUtils.isEmpty(ans)) {
            System.out.println("world");
        }
    }

    @Test
    public void test24() {
        boolean ans = StringUtils.equalsIgnoreCase(null, "hello");
        System.out.println(ans);
    }

    @Test
    public void test25() {
        String ans = "Bnc";
        System.out.println(ans.toLowerCase());
    }

    @Test
    public void test26() {
        String ans = "Bnc";
        Map<String, String> finalAns = new HashMap<>();
        finalAns.put(ans, null);
        System.out.println(finalAns);
    }
}
