package com.study.basicknowledge.knowledgetest;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/18 13:50
 */
public class NullTest {

    @Test
    public void test() {
        String a = "123";

        if (StringUtils.isNumeric(a)) {
            System.out.println("hello world");
        } else {
            System.out.println("are you ok");
        }

    }

}
