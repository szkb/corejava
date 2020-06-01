package com.study.basicknowledge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;

//编写元注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnnotaionBase {
    String value() default "";
}
 
//编写子注解，其中子注解打上了元注解@AnnotaionBase标识
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AnnotaionBase
@interface AnnotationChild {
 
    @AliasFor(annotation = AnnotaionBase.class, attribute = "value")
    String extendValue() default "";
}
 
 
//编写测试类
@AnnotationChild(extendValue = "extendValue")
class ExtendClass {
 
}
 
//编写测试代码
public class ExtendAnnotationTest {

    @Test
    public void test() throws NoSuchMethodException {
        AnnotaionBase annotaionBase = AnnotatedElementUtils
            .findMergedAnnotation(ExtendClass.class, AnnotaionBase.class);
        assert annotaionBase != null;
        Assert.assertEquals("", "extendValue", annotaionBase.value());
    }

}