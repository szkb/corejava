package com.study.basicknowledge.basicjava.bit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2022/3/7 17:15
 */
public class BitTest {
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
        long flags = 0L;
        flags = flags | 1;
        flags = flags | 1;
        System.out.println((flags & 1) > 0);
        System.out.println((flags & 1) > 0);
    }

    @Test
    public void test1() {
        List<User> ans = new ArrayList<>();
        User user = new User();
        user.setName("hello");
        ans.add(user);

        User user1 = new User();
        user1.setName("world");
        ans.add(user1);

        System.out.println(ans);
        Collections.swap(ans,0, 2);
        System.out.println(ans);
    }

    @Test
    public void test3() {
        String a = "hello";
        String b = "338888888";
        String c = "-33";
        String d = "-33.0";
        String e = "-3 3.05";
        String f = "hello1";
        System.out.println(NumberUtils.isParsable(a));
        System.out.println(NumberUtils.isParsable(b));
        System.out.println(NumberUtils.isParsable(c));
        System.out.println(NumberUtils.isParsable(d));
        System.out.println(NumberUtils.isParsable(e));
        System.out.println(NumberUtils.isParsable(f));
        System.out.println(new BigDecimal("1*10"));
    }
}
