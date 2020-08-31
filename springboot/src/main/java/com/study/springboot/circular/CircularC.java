package com.study.springboot.circular;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author hangwu
 * @date 2020/8/27 9:13
 */
@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class CircularC {

    public void drinking() {
        System.out.println("I am drinking");
    }
}
