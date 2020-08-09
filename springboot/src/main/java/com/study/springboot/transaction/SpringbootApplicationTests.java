package com.study.springboot.transaction;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootTest
@EnableTransactionManagement
public class SpringbootApplicationTests {

    @Autowired
    PersonService personService;

    @Test
    public void test() {
        personService.testTx();
    }
}
