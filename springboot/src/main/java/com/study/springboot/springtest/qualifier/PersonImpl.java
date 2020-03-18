package com.study.springboot.springtest.qualifier;

import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/3/12 10:43
 */

@Service("personImpl")
public class PersonImpl implements Person{

    @Override
    public void run() {
        System.out.println("I love running");
    }
}
