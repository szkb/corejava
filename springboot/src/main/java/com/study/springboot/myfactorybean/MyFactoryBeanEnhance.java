package com.study.springboot.myfactorybean;

import java.lang.reflect.Method;
import org.springframework.beans.factory.*;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class MyFactoryBeanEnhance implements FactoryBean, InitializingBean, DisposableBean {

    private Object proxyObject;

    private Object target;

    private String interfaceName;

    @Override
    public Object getObject() throws Exception {

        return proxyObject;
    }

    @Override
    public Class<?> getObjectType() {
        return proxyObject.getClass() == null ? Object.class : proxyObject.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * MyFactoryBean 对象销毁的回调方法
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy ....");

    }

    /**
     * MyFactoryBean 对象实例化的方法
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---afterPropertiesSet---");
        proxyObject = Proxy.newProxyInstance(
            this.getClass().getClassLoader()
            , new Class[]{Class.forName(interfaceName)}
            , new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("----代理方法执行开始----");
                    Object obj = method.invoke(target, args);
                    System.out.println("----代理方法执行结束----");
                    return obj;
                }
            });
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}