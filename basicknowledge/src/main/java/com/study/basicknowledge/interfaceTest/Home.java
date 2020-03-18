package com.study.basicknowledge.interfaceTest;

/**
 * @author hangwu
 * @date 2020/3/11 19:31
 */
public class Home {

    private Parent parent;

    public Home (Parent parent) {
        this.parent = parent;
    }

    void print() {
        parent.eat();
    }

}
