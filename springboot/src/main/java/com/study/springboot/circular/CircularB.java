package com.study.springboot.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author hangwu
 * @date 2020/7/4 14:31
 */
//@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class CircularB {

//    @Autowired
//    private CircularA circularA;

    public void drinking() {
        System.out.println("I am drinking");
    }
}
