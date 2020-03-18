package com.study.basicknowledge.interfaceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hangwu
 * @date 2020/3/11 19:31
 */

@org.springframework.boot.test.context.SpringBootTest
class SpringBootTest {
    @Autowired
    private Home home;

    @Test
    void contextLoads() {
        home.print();
    }

}