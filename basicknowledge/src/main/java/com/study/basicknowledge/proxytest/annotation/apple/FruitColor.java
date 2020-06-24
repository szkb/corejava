package com.study.basicknowledge.proxytest.annotation.apple;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;

/**
 * 水果颜色注解
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    public enum Color {BLUE, RED, GREEN}

    ;

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;

}