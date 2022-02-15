package com.study.basicknowledge.time;

import com.study.basicknowledge.basicjava.annotation.Company;
import com.study.basicknowledge.basicjava.annotation.User;
import com.study.basicknowledge.basicjava.interfaceTest.defaulttest.C;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    @Test
    public void test3() {
        List<String> ans = new ArrayList<>();
        ans.add("hello");

        List<String> word = new ArrayList<>();
        word.addAll(ans);

        word.removeIf(item -> item.equalsIgnoreCase("hello"));

        System.out.println(ans);
        System.out.println(word);
    }

    @Test
    public void test4() throws CloneNotSupportedException {
        User user = new User();
        user.setAge("28");
        user.setName("hello");
        Company company = new Company();
        company.setTel("110");
        user.setCompany(company);
        User ans = (User) user.clone();
        System.out.println(ans.getName());

        user.setName("world");
        user.getCompany().setTel("120");
        System.out.println(user.getName());
        System.out.println(ans.getName());
        System.out.println(user.getCompany().getTel());
        System.out.println(ans.getCompany().getTel());
    }

    @Test
    public void test5() {
        String temp = null;
        System.out.println("hello".equals(temp));
    }
}
