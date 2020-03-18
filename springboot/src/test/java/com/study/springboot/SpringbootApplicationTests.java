package com.study.springboot;

import com.study.springboot.springtest.Girl;
import com.study.springboot.springtest.Home;
import com.study.springboot.springtest.qualifier.Person;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    private Home home;

    @Qualifier("personImpl2")
    @Autowired
    private Person person;

    @Resource(name = "personImpl")
    private Person person1;

    @Resource(name = "old")
    private Girl girl;

    @Test
    void test() {
        home.print();
    }

    @Test
    void test1() {
        System.out.println(girl.getName());
    }

    @Test
    void test2() {
        person.run();
        person1.run();
    }
}
