package com.study.basicknowledge.basicjava.function;

import java.util.function.Supplier;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/3/18 15:16
 */
public class SupplierDemo {

    public static String supplierTest(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String args[]) {
        String name = "冷冷的天";
        // () -> name.length() 无参数，返回一个结果（字符串长度）
        // 所以该lambda表达式可以实现Supplier接口
        System.out.println(supplierTest(() -> name.length() + ""));
    }

    @Test
    public void test() {
        Supplier<String> supplier = () -> "hello world";
        System.out.println(supplier.get());
    }

    @Test
    public void test2() {
        Supplier<Student> supplier = Student::new;
        System.out.println(supplier.get().getName());
    }
}
