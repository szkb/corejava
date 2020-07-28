package com.study.springboot.annotationdemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/3/11 19:30
 */

@Component
public class Son implements Parent {

    private Hobby hobby;

    public Son(Hobby hobby) {
        System.out.println("构造函数");
        this.hobby = hobby;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        System.out.println("set函数");
        this.hobby = hobby;
    }

    @Override
    public void eat() {
        System.out.println("I like eating chicken");
    }
}
