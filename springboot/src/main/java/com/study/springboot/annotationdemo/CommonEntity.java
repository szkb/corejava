package com.study.springboot.annotationdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hangwu
 * @date 2020/3/11 21:04
 */

@Configuration
public class CommonEntity {

    @Bean(name = "old")
    public Girl getOldGirl() {
        return new Girl("hello");
    }

    @Bean(name = "new")
    public Girl getNewGirl() {
        return new Girl("world");
    }

}
