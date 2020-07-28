package com.study.springboot.annotationdemo;

import javax.annotation.Priority;
import org.junit.Test;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/4/3 19:54
 */

@Primary
@Component
public class Daughter implements Parent {

    @Override
    public void eat() {
        System.out.println("yes");
    }

    @Override
    public boolean getValue() {
        return Parent.super.getValue();
    }

    @Test
    public void test() {
        System.out.println(getValue());
    }
}
