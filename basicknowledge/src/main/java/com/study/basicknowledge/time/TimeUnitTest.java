package com.study.basicknowledge.time;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

/**
 * @author hangwu
 * @date 2020/4/1 13:47
 */
public class TimeUnitTest {

    @Test
    public void test() {
        long time = 1;
        System.out.println(TimeUnit.MINUTES.toMillis(time));
    }

    @Test
    public void test2() {
        List<String> ans = new ArrayList<>();
        ans.add("");
        System.out.println(ans.size());
    }

}
