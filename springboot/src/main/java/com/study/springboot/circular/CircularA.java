package com.study.springboot.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author hangwu
 * @date 2020/7/4 14:30
 */
@Component
public class CircularA {

    @Autowired
    private CircularB circularB;

//    public CircularA(CircularB circularB) {
//        this.circularB = circularB;
//    }

    public void eat() {
        System.out.println("hello world");
    }

    public void test() {
//        CircularC circularC = createCircularC();
        System.out.println();
    }

}
