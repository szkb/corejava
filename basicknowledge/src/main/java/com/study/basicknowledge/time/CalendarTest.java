package com.study.basicknowledge.time;

import java.util.Calendar;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/3/23 12:10
 */
public class CalendarTest {

    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        System.out.println(calendar.getTime());
    }
}
