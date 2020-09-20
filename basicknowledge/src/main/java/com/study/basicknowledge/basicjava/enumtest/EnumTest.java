package com.study.basicknowledge.basicjava.enumtest;

import java.util.Collections;
import java.util.List;
import org.junit.Test;
import test.BookingChannelEnum;

/**
 * @author hangwu
 * @date 2020/4/1 19:53
 */
public class EnumTest {

    @Test
    public void test() {
        String a = null;
        List<String> test = Collections.singletonList(a);
        if (test.get(0) == null) {
            System.out.println("hello");
        }
        System.out.println(test.size());
    }

    @Test
    public void test2() {
        String answer = String.format("%s%s", "hello world", "ok");
        System.out.println(answer);

        String title = String.format("[[title=%s]]", "yes");
        System.out.println(title);
    }

    @Test
    public void test3() {
        BookingChannelEnum bookingChannelEnum = BookingChannelEnum.ABACUS;
        System.out.println(bookingChannelEnum);
        System.out.println(bookingChannelEnum.getValue());
    }

}
