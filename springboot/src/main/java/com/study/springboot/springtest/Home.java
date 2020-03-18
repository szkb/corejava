package com.study.springboot.springtest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/3/11 19:31
 */

@Service
public class Home {

    private Parent parent;

    public Home (Parent parent) {
        this.parent = parent;
    }

    public void print() {
        parent.eat();
    }

}
