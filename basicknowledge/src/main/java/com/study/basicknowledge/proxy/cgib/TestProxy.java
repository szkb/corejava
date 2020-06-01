package com.study.basicknowledge.proxy.cgib;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.basicknowledge.proxy.UserService;
import java.io.*;
import java.lang.reflect.Modifier;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import sun.misc.ProxyGenerator;

public class TestProxy {

    @Test
    public void testCglibProxy() throws IOException {
        //目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        //执行代理对象方法
        proxy.save();
    }
}