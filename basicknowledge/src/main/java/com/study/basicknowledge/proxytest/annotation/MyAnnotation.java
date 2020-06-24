package com.study.basicknowledge.proxytest.annotation;

import java.lang.annotation.*;
import org.springframework.core.annotation.AliasFor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {

    @AliasFor("location")
    String value() default "";

    @AliasFor("address")
    String alias() default "";

}