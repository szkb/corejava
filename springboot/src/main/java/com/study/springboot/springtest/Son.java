package com.study.springboot.springtest;

import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/3/11 19:30
 */

@Service
public class Son implements Parent {

    @Override
    public void eat() {
        System.out.println("I like eating chicken");
    }
}
