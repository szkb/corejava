package com.study.springboot.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hangwu
 * @date 2020/8/7 17:31
 */
@Service
public class PersonService {

    private static String name;

    @Transactional
    public void testTx() {
        updatePerson(name);
        errorUpdatePerson(name);
        System.out.println(name);
    }

    public void testName() {
        System.out.println("world");
    }

    private void errorUpdatePerson(String name) {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updatePerson(String name) {
        name = "hello";
    }
}
