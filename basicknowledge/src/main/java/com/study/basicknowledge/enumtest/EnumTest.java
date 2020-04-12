package com.study.basicknowledge.enumtest;

import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

/**
 * @author hangwu
 * @date 2020/4/1 19:53
 */
public class EnumTest {

    @Test
    public void test() {
        String a = null;
        List<String> test = Collections.singletonList(a);
        if (test.get(0) == null) {
            System.out.println("hello");
        }
        System.out.println(test.size());
    }

    @Test
    public void test2() {
        String answer = String.format("%s%s", "hello world", "ok");
        System.out.println(answer);

        String title = String.format("[[title=%s]]", "yes");
        System.out.println(title);
    }

}
