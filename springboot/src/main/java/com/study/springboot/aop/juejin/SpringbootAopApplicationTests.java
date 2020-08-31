package com.study.springboot.aop.juejin;

import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAopApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void testAop1() {
        userService.save("张三");
        Assert.assertTrue(true);
    }

    @Test
    public void testAop2() {
        userService.save("a");
    }
    
    @Test
    public void testAop3() {
        userService.testAnnotationAop();
    }

    @Test
    public void testAop4() {
        System.out.println(userService.getMathNumber());
    }
}
