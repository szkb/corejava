package com.study.springboot.annotationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author hangwu
 * @date 2020/7/5 10:56
 */

@Component
public class Address {

    @Autowired
    private Home home;

    public void print() {
        System.out.println(home.toString());
    }

}
