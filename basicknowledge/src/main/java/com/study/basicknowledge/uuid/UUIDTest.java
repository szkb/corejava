package com.study.basicknowledge.uuid;

import java.util.UUID;
import org.testng.annotations.Test;

/**
 * @author hangwu
 * @date 2019/12/30 17:05
 */
public class UUIDTest {

    @Test
    public void test() {
        System.out.println(UUID.randomUUID().toString());
    }
}
