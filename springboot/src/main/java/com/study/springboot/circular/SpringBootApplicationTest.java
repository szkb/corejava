package com.study.springboot.circular;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hangwu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationTest {

    @Autowired
    private CircularB circularb;

    @Autowired
    private CircularA circulara;

    @Test
    public void testCircularTest() {
        circulara.eat();
    }

    @Test
    public void testPrototype() {
        circulara.test();
        circulara.test();
        circulara.test();
    }
}
