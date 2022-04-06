package com.study.basicknowledge.basicjava.gc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Test;

/**
 * GCRoots 测试：虚拟机栈（栈帧中的局部变量）中引用的对象作为GCRoots -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 * <p>
 * 扩展：虚拟机栈中存放了编译器可知的八种基本数据类型,对象引用,returnAddress类型（指向了一条字节码指令的地址）
 *
 * @author ljl
 */
public class TestGCRoots01 {

    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];

    public static void main(String[] args) {
        method01();
        System.out.println("返回main方法");
        System.gc();
        System.out.println("第二次GC完成");
    }

    public static void method01() {
        TestGCRoots01 t = new TestGCRoots01();
        System.gc();
        System.out.println("第一次GC完成");
    }

    @Test
    public void test() {
        BigDecimal a = new BigDecimal(168);
        BigDecimal b = new BigDecimal(132.0522);
        BigDecimal rate = (new BigDecimal(50).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)
        );
        BigDecimal ans = a.subtract(b).multiply(rate).add(b);
        System.out.println(ans);
    }

}