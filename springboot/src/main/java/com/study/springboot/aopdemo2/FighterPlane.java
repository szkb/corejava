package com.study.springboot.aopdemo2;

import org.springframework.stereotype.Component;

@Component("fighterPlane")
public class FighterPlane implements Fireable {
    @Override
    public int attack(Object obj) {
        System.out.println("战斗机开火! 造成200点伤害");
        return 200;
    }
}
