package test;

import com.study.basicknowledge.basicjava.interfaceTest.defaulttest.B;
import com.study.basicknowledge.basicjava.stream.reduce.ReduceBenchMark.User;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import test.ExampleTest.Student;

/**
 * @author hangwu
 * @date 2020/9/30 11:10
 */
public class CaseTest {

    private BigDecimal number;

    private int math;

    public static void main(String[] args) throws IOException {
        // 节点流FileOutputStream直接以A.txt作为数据源操作
        FileOutputStream fileOutputStream = new FileOutputStream("A.txt");
        // 过滤流BufferedOutputStream进一步装饰节点流，提供缓冲写
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
            fileOutputStream);
        // 过滤流DataOutputStream进一步装饰过滤流，使其提供基本数据类型的写
        DataOutputStream out = new DataOutputStream(bufferedOutputStream);
        out.writeInt(3);
        out.writeBoolean(true);
        out.flush();
        out.close();
        // 此处输入节点流，过滤流正好跟上边输出对应，读者可举一反三
        DataInputStream in = new DataInputStream(new BufferedInputStream(
            new FileInputStream("A.txt")));
        System.out.println(in.readInt());
        System.out.println(in.readBoolean());
        in.close();
    }

    @Test
    public void test() {
        String s = "hello";
    }

    @Test
    public void test2() {
        String configValue = "hello,world, actual";
        String delimiter = ",";
        StringTokenizer tokenizer = new StringTokenizer(configValue, delimiter);

        while (tokenizer.hasMoreElements()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    @Test
    public void test3() {
        long time = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        System.out.println(calendar);
    }

    @Test
    public void test4() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = new Date(1604678400000L);
        String str = sdf.format(date);
        System.out.println(str);
    }

    @Test
    public void test5() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setName("hello");
        studentList.add(student);

        Student student2 = new Student();
        studentList.add(student2);
        System.out.println(studentList.stream().map(Student::getName).filter(Objects::nonNull).
            collect(Collectors.toList()));
    }

    @Test
    public void test6() {
        List<String> ans = new ArrayList<>();
        ans.add("1");
        ans.add("1");

        System.out.println(new HashSet<>(ans));
    }

    @Test
    public void test7() {
        List<String> ans = new ArrayList<>();
        ans.add(null);
        ans.add(null);

        System.out.println(ans.size());
        System.out.println(ans.isEmpty());
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> number1 = new HashSet<>(nums1.length);
        Set<Integer> number2 = new HashSet<>(nums2.length);
        for (int item : nums1) {
            number1.add(item);
        }

        for (int item : nums2) {
            number2.add(item);
        }
        number1.retainAll(number2);
        int[] ans = new int[number1.size()];
        int i = 0;
        for (Integer item : number1) {
            ans[i++] = item;
        }
        return ans;
    }

    @Test
    public void test8() {

        int[] ans = {3, 3, 6, 7, 8, 9, 2, 1, 0};
        Arrays.sort(ans);
    }

    @Test
    public void test9() {
//        List<String> ans = Arrays.asList("hello", "world");
//        System.out.println(ans.indexOf("world"));

        Pair<String, String> pair = Pair.of("aku", "female");
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());

        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }

    @Test
    public void test10() {
        System.out.println(number);
        System.out.println(math);
        System.out.println(Double.NaN + 1000);
    }

    @Test
    public void test11() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() + 1000 * 60 * 60 * 6);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void test12() {
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];
        Map<Integer, Integer> numPostions = IntStream.range(0, arr2.length).boxed()
            .collect(Collectors.toMap(i -> arr2[i], i -> i));
        Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
            int a1 = numPostions.getOrDefault(o1, 1001);
            int a2 = numPostions.getOrDefault(o2, 1001);
            if (a1 != 1001 || a2 != 1001) {
                return a1 - a2;
            }

            return o1 - o2;
        }).mapToInt(o -> o).toArray();
    }

    @Test
    public void test13() {
        final User user = new User("kobe", 12, null);
        user.setAge(15);
        System.out.println(user);
    }

    @Test
    public void test14() {
        List<User> ans = new ArrayList<>();
        System.out.println(ans.get(0).getAge());
    }

    @Test
    public void test15() {
        long ans = 1 << 2;
        System.out.println(ans);
    }

    @Test
    public void test16() {
        System.out.println(new ArrayList<>().get(0));
    }

    @Test
    public void test17() {
        BigDecimal a = new BigDecimal("3");
        System.out.println(a.multiply(new BigDecimal(21)).setScale(0, RoundingMode.HALF_UP));
    }

}
