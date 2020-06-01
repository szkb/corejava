package com.study.springboot.aop.juejin;

import com.study.springboot.aop.juejin.Log;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAop {

    @Pointcut(value = "@annotation(log)", argNames = "log")
    public void pointcut(Log log) {
    }

    @Around(value = "pointcut(log)", argNames = "joinPoint,log")
    public Object around(ProceedingJoinPoint joinPoint, Log log) throws Throwable {
        try {
            System.out.println(log.value());
            System.out.println("around");
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            System.out.println("around");
        }
    }

    @Before("@annotation(com.study.springboot.aop.juejin.Log)")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log log = method.getAnnotation(Log.class);
        System.out.println("注解式拦截 " + log.value());
    }
}


