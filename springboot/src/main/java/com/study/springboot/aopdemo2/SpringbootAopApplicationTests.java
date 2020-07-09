package com.study.springboot.aopdemo2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAopApplicationTests {

    @Qualifier("fighterPlane")
    @Autowired
    private Fireable fireable;

//    @Resource(name = "tank")
//    private Fireable fireable1;

    @Test
    public void testAop() {
        System.out.println("启动了==================");

        Object tempTarget = new Object();
        fireable.attack(tempTarget);
        System.out.println(fireable);
    }

//    @Test
//    public void testAOP1() {
//        System.out.println("启动了==================");
//
//        Object tempTarget = new Object();
//        fireable1.attack(tempTarget);
//    }
}
