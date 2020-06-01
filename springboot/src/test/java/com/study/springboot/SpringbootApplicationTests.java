package com.study.springboot;

import com.study.springboot.annotationdemo.Home;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private Home home;

    @Test
    void test() {
        home.print();
    }
}
