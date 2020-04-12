package com.study.springboot.springtest;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author hangwu
 * @date 2020/3/11 19:31
 */

@Service
public class Home {

    private List<Parent> parent;

    public Home (List<Parent> parent) {
        this.parent = parent;
    }

    @PostConstruct
    public void initHome() {
        System.out.println(parent);
        System.out.println(parent.size());
    }

    public void print() {
        System.out.println("hello world");
    }

}
