package com.study.basicknowledge.datastructure.string;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/8/10 16:49
 */
public class StringTest {

    @Test
    public void test() {
        String s5 = new String("Hello"); //先在常量池中创建，再在堆中创建，返回的数值s5是堆中的地址
        String s6 = s5.intern();//返回的数值s6 ，是常量池中的地址
        String s10 = "Hello";//返回的数值s10，是常量池中的地址

        System.out.println(s5 == s6);  //输出false

        System.out.println(s6 == s10);  //输出true
    }
}
