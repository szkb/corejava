package com.study.basicknowledge.basicjava.abstracttest;

/**
 * @author hangwu
 * @date 2020/10/16 13:48
 */
public class ServiceA extends AbstractService {

    @Override
    protected void generate() {
        this.ans = "serviceA";
    }

    void alter() {
        this.ans = "world";
    }

    public static void main(String[] args) {
        ServiceA serviceA = new ServiceA();
        serviceA.alter();
        System.out.println(serviceA.ans);
    }
}
