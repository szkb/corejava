package com.study.springboot.ioc;

import com.study.springboot.ioc.constructor.JapaneseMock;
import com.study.springboot.ioc.set.Person;
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
    private Person japanese;

    @Test
    public void test() {
        japanese.useAxe();
        JapaneseMock.useAxe();
    }

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            test();
            System.out.println("******************");
        }
    }
}
