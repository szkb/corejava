package com.study.springboot.myfactorybean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author hangwu
 * @date 2020/7/8 12:04
 */
public class MyFactoryTest {

    @Test
    public void test() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        Object bean = bf.getBean(IUserService.class);
        System.out.println(bean);
    }

    @Test
    public void test1() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        Object bean = bf.getBean("myFactoryBean");
        System.out.println(bean);
    }

    @Test
    public void test2() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        Object bean = bf.getBean("&myFactoryBean");
        System.out.println(bean);
    }

    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextEnhance.xml");
        IUserService bean = (IUserService) ac.getBean("myFactoryBean");
        System.out.println("****************");
        bean.doSome();
        System.out.println();
    }
}
