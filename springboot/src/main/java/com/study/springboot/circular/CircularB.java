package com.study.springboot.circular;

import org.springframework.stereotype.Component;

/**
 * @author hangwu
 * @date 2020/7/4 14:31
 */

@Component
public class CircularB {

    private CircularA circularA;

    public CircularB(CircularA circularA) {
        this.circularA = circularA;
    }
}
