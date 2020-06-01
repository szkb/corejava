package com.study.springboot.annotationdemo.qualifier;

import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/3/12 10:44
 */

@Service("personImpl2")
public class PersonImpl2 implements Person {

    @Override
    public void run() {
        System.out.println("I love running marathon");
    }
}
