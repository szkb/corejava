package com.study.springboot.springtest;

import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/4/3 19:54
 */

@Service
public class Daughter implements Parent {

    @Override
    public void eat() {
        System.out.println("yes");
    }
}
