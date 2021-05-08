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

    @Test
    public void test2() {
        Calendar departDate = Calendar.getInstance();
        long leaveDate = System.currentTimeMillis() + 24 * 60 * 60 * 1000;
        departDate.setTimeInMillis(leaveDate);

        Calendar date = Calendar.getInstance();
        long mill = System.currentTimeMillis() + 24 * 60 * 60;
        date.setTimeInMillis(mill);

        System.out.println(departDate.after(date));

    }
}
