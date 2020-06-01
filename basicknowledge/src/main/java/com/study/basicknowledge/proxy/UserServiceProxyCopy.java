package com.study.basicknowledge.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import org.junit.Test;

public final class UserServiceProxyCopy extends Proxy implements UserService {

    private static Method m1;
    private static Method m2;
    private static Method m4;
    private static Method m0;
    private static Method m3;

    public UserServiceProxyCopy(InvocationHandler var1) {
        super(var1);
    }

    public final boolean equals(Object var1) {
        // 省略...
        return true;
    }

    public final String toString() {
        // 省略...
        return "hello";
    }

    public final void select() {
        try {
            super.h.invoke(this, m4, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final int hashCode() {
        // 省略...
        return 0;
    }

    public final void update() {
        try {
            super.h.invoke(this, m3, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m4 = Class.forName("proxy.UserService").getMethod("select");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
            m3 = Class.forName("proxy.UserService").getMethod("update");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }

    @Test
    public void test() {
        update();
        select();
    }
}