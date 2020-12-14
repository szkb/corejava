package com.study.basicknowledge.time;

import java.time.LocalDate;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/12/6 18:03
 */
public class Java8Time {

    @Test
    public void test() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
    }

}
