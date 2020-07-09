package com.study.springboot.aopdemo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hangwu
 * @date 2020/7/9 11:08
 */
public class MainAppAnnotation {

    @Test
    public void test() {
        System.out.println("启动了==================");

        Object tempTarget = new Object();

        ApplicationContext context = new ClassPathXmlApplicationContext("zhushipeizhiAop.xml");
        Fireable fighterPlane = context.getBean("fighterPlane", Fireable.class);
        Fireable tank = context.getBean("tank", Fireable.class);

        fighterPlane.attack(tempTarget);
        System.out.println();
        tank.attack(tempTarget);
    }
}
