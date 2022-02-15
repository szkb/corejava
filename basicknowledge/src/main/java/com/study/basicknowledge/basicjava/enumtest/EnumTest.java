package com.study.basicknowledge.basicjava.enumtest;

import static com.study.basicknowledge.basicjava.enumtest.MemberLevelEntity.*;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import java.math.BigDecimal;
import java.util.*;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;
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

//    @Test
//    public void test3() {
//        BookingChannelEnum bookingChannelEnum = BookingChannelEnum.valueOf("NO_NEED_PnR");
//        System.out.println(bookingChannelEnum);
//        System.out.println(bookingChannelEnum.getValue());
//    }

    @Test
    public void test4() {
        String memberLevel = "Gold";
        final String a = "hello";
        System.out.println("Gold".hashCode());
        System.out.println("Platina".hashCode());
        System.out.println("Diamond".hashCode());
        System.out.println(Gold.name().hashCode());
        switch (memberLevel) {
            case "Gold.name()":
                System.out.println("hello");
                break;
            case "Platina":
                System.out.println("world");
                break;
            case "Diamond":
                System.out.println("hello world");
                break;
            default:
                System.out.println("are you ok");
        }
    }

    @Test
    public void test5() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "1");
        System.out.println(map.get("hello"));
    }

    enum Color
    {
        RED, GREEN, BLUE;

        // 构造函数
        private Color()
        {
            System.out.println("Constructor called for : " + this.toString());
        }

        public void colorInfo()
        {
            System.out.println("Universal Color");
        }
    }

    @Test
    public void test6() {
        Color c1 = Color.RED;
        System.out.println(c1);
        c1.colorInfo();
    }


}
