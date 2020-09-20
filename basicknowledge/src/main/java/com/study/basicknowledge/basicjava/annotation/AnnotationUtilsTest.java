package com.study.basicknowledge.basicjava.annotation;


import org.junit.Test;

@MyAnnotation(value = "aa", alias = "bb")
public class AnnotationUtilsTest {

    @Test
    public void testAliasfor2() {
        MyAnnotation ann = getClass().getAnnotation(MyAnnotation.class);
        System.out.println(ann.value());
        System.out.println(ann.alias());
    }
}