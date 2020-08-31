package com.study.springboot.beanlifecycle.beanfactorypostprocessor;


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
    private BBean bBean;

    @Test
    public void test() {
        System.out.println(bBean);
        System.out.println(bBean.getABean());
    }
}
