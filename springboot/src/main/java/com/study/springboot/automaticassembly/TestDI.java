package com.study.springboot.automaticassembly;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("autoassembly.xml");
        Restaurant restaurant = ac.getBean("restaurant", Restaurant.class);
        System.out.println(restaurant);
    }
}