package com.study.springboot.ioc.set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hangwu
 * @date 2020/9/12 12:38
 */
public class IOCTest {

    @Test
    public void test() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
        System.out.println("容器初始化成功");
        //得到Person，并使用
        Person person = factory.getBean("chinese",Person.class);
        System.out.println(person);
    }

    @Test
    public void test2() {
        ApplicationContext factory = new ClassPathXmlApplicationContext("ioc.xml");
        System.out.println("容器初始化成功");
        //得到Person，并使用
        Person person = factory.getBean("japanese",Person.class);
        System.out.println(person);
    }
    
}
