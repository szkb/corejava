package com.study.springboot.annotationdemo;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/3/11 19:31
 */

@Service
public class Home {

    public void print() {
        System.out.println("hello world");
    }

}
