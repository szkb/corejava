package com.study.basicknowledge.basicjava.generic;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2022/12/15 10:54
 */
public class GenericExample {

    class Fruit {

    }

    class Apple extends Fruit {

    }

    class Plate<T> {

        private T item;

        public Plate(T t) {
            this.item = t;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }

    /**
     * PECS原则
     * <a href="https://www.jianshu.com/p/f1405bd19dea">...</a>
     */
    @Test
    public void test() {
        Plate<? super Fruit> p = new Plate<>(new Apple());
    }

}
