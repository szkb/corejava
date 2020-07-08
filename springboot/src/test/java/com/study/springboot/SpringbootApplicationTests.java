package com.study.springboot;

import com.study.springboot.annotationdemo.Home;
import com.study.springboot.circular.CircularA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private Home circularA;

    @Test
    void test() {
        circularA.print();
        System.out.println(circularA);
    }
}
