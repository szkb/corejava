package com.study.springboot.circular;

import org.springframework.stereotype.Component;

/**
 * @author hangwu
 * @date 2020/7/4 14:30
 */

@Component
public class CircularA {

//    private CircularB circularB;
//
//    public CircularA(CircularB circularB) {
//        this.circularB = circularB;
//    }

    public void eat() {
        System.out.println("hello world");
    }
}
