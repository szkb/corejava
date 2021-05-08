package test;

import java.math.BigDecimal;
import java.util.*;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2021/2/22 17:13
 */
public class Example {

    public static final String DATETIME_NORMAL_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String ES_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS+08:00";

    @Test
    public void test() {
        String s = "world ";
        changeString(s);
        System.out.println(s);
        System.out.println(s.trim());
        System.out.println(s);
    }

    public void changeString(String s) {
        s += "hello";
    }

    @Test
    public void test1() {
        String s = null;
        System.out.println(s.equals("hello"));
        System.out.println("hello".equals(s));
    }

    @Test
    public void test2() {
        BigDecimal hello = new BigDecimal(13);
        BigDecimal world = new BigDecimal(13);
        System.out.println(hello.compareTo(world));
    }

    @Test
    public void test3() {
        List<String> ans = Arrays.asList("hello", "world");
        List<String> compare = Arrays.asList("f", "123");

        System.out.println(compare.stream().noneMatch(item -> ans.contains(item)));
    }

    @Test
    public void test4() {
        String ans = "123456";
        try {
            int cityId = Integer.parseInt(ans);
            System.out.println(cityId);
        } catch (NumberFormatException ex) {
            System.out.println("hello world");
        }
    }

    @Test
    public void test5() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
    }
}
