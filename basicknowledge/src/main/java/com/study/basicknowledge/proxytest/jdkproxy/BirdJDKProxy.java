package com.study.basicknowledge.proxytest.jdkproxy;

import com.study.basicknowledge.proxytest.Bird;
import com.study.basicknowledge.proxytest.Flyable;
import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;
import org.junit.Test;
import sun.misc.ProxyGenerator;

/**
 * @author hangwu
 * @date 2020/6/1 14:29
 */
public class BirdJDKProxy {

    @Test
    public void test() {
        // 设置变量可以保存动态代理类，默认名称以 $Proxy0 格式命名
        // System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 1. 创建被代理的对象，UserService接口的实现类
        Bird bird = new Bird();
        // 2. 获取对应的 ClassLoader
        ClassLoader classLoader = bird.getClass().getClassLoader();
        // 3. 获取所有接口的Class
        Class[] interfaces = bird.getClass().getInterfaces();
        // 4. 创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        //     这里创建的是一个自定义的日志处理器，须传入实际的执行对象 bird
        InvocationHandler logHandler = new LogHandler(bird);
        /*
		   5.根据上面提供的信息，创建代理对象 在这个过程中，
               a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
               b.然后根据相应的字节码转换成对应的class，
               c.然后调用newInstance()创建代理实例
		 */
        Flyable proxy = (Flyable) Proxy.newProxyInstance(classLoader, interfaces, logHandler);

        // 写到文件里面
//        writeInFile(proxy);

        // 调用代理的方法
        proxy.fly();

        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        // ProxyUtils.generateClassFile(bird.getClass(), "UserServiceProxy");
    }

    private void writeInFile(Flyable proxy) {
        try {
            byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "com.study.basicknowledge.proxytest.jdkproxy.ProxyTemp", new Class[]{Flyable.class}, Modifier.FINAL);
            FileOutputStream out = new FileOutputStream(new File("D:/Users/testJavaProject/core/basicknowledge"
                + "/src/main/java/com/study/basicknowledge/proxytest/jdkproxy/ProxyTemp.class"));
            out.write(proxyClassFile);
            out.flush();
            out.close();
            System.out.println(proxy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
