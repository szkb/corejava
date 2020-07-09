package com.study.springboot.aopdemo2;

import org.springframework.stereotype.Component;

@Component("tank")
public class Tank implements Fireable {
    @Override
    public int attack(Object obj) {
        System.out.println("坦克开火! 造成100点伤害! ");
        return 100;
    }
}
