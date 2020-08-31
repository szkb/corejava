package com.study.springboot;

import com.study.springboot.annotationdemo.Parent;
import com.study.springboot.transaction.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootTest
@EnableTransactionManagement
class SpringbootApplicationTests {
//
//    @Autowired
//    private Parent daughter;
//
//    @Test
//    void test() {
//        daughter.eat();
//        System.out.println(daughter);
//    }
//
//    @Test
//    void test2() {
//        for (int i = 0; i < 10; i++) {
//            test();
//        }
//    }

    @Autowired
    PersonService personService;

    @Test
    public void testTransaction() {
        personService.testName();
    }
}
