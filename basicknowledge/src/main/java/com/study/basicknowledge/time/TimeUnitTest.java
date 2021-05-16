package com.study.basicknowledge.time;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

/**
 * @author hangwu
 * @date 2020/4/1 13:47
 */
public class TimeUnitTest {

    @Test
    public void test() {
        long time = 1;
        System.out.println(TimeUnit.MINUTES.toMillis(time));
    }

    @Test
    public void test2() {
        List<String> ans = new ArrayList<>();
        ans.add("");
        System.out.println(ans.size());
    }

    @Test
    public void test3() {
        List<Integer> gifts = new ArrayList<>();
        gifts.add(1);
        gifts.add(2);
        gifts.add(3);
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        gifts.removeAll(temp);
        System.out.println(gifts);
    }

    @Test
    public void test4() {
        long ans = 576460795924185104L;
        System.out.println((ans & 0x20000000000000L) > 0);
    }

    @Test
    public void test5() {
        BigDecimal salePrice = new BigDecimal(10);
        BigDecimal roomSalePrice = new BigDecimal(3.8);
        BigDecimal ans = salePrice.add(roomSalePrice.divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_DOWN));
        System.out.println(ans);

        System.out.println(ans.setScale(0, RoundingMode.UP));
    }

    @Test
    public void test6() {
        boolean record = false;
        for (int i = 0; i < 3; i++) {
            testRecord(record);
        }
        System.out.println(record);
    }

    private void testRecord(boolean record) {
        if (!record) {
            record = true;
            System.out.println("hello world");
        }
    }

}
