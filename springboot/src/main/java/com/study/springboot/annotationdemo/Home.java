package com.study.springboot.annotationdemo;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/3/11 19:31
 */

@Service
public class Home {

    @Autowired
    private Address address;

    public void print() {
        System.out.println("hello world");
    }

    public void eat() {
        System.out.println(address.toString());
    }

}
