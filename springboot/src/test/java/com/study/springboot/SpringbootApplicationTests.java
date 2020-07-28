package com.study.springboot;

import com.study.springboot.annotationdemo.Home;
import com.study.springboot.annotationdemo.Parent;
import com.study.springboot.circular.CircularA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private Parent daughter;

    @Test
    void test() {
        daughter.eat();
        System.out.println(daughter);
    }

    @Test
    void test2() {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }
}
