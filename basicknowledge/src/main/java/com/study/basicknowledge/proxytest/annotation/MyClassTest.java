package com.study.basicknowledge.proxytest.annotation;

import java.lang.annotation.*;
import java.util.function.Consumer;
import org.junit.Test;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotationUtils;

//定义注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAliasAnnotation {
 
    @AliasFor(value = "location")
    String value() default "";
 
    @AliasFor(value = "value")
    String location() default "";
}

//编写测试类
class MyClass {
 
    @MyAliasAnnotation(location = "这是location")
    public static void one(){
    }
 
    @MyAliasAnnotation(value = "这是value")
    public static void one2(){
    }
}

//编写测试代码
public class MyClassTest {
    
    @Test
    public void test1() throws NoSuchMethodException {
        Consumer<MyAliasAnnotation> logic = a -> {
        };
 
        MyAliasAnnotation aliasAnnotation = AnnotationUtils
            .findAnnotation(
                MyClass.class.getMethod("one"), MyAliasAnnotation.class);
        System.out.println(aliasAnnotation.value());
        logic.accept(aliasAnnotation);
 
        MyAliasAnnotation aliasAnnotation2 = AnnotationUtils.findAnnotation(
            MyClass.class.getMethod("one2"), MyAliasAnnotation.class);
        System.out.println(aliasAnnotation2.location());
        logic.accept(aliasAnnotation2);
 
    }
 
}