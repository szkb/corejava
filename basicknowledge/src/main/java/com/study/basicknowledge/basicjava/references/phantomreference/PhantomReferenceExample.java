package com.study.basicknowledge.basicjava.references.phantomreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/9/13 11:01
 */
public class PhantomReferenceExample {

    @Test
    public void test() {
        String name = "a";
        ReferenceQueue<String> prq = new ReferenceQueue<>();
        PhantomReference<String> nameRf = new PhantomReference<>(name, prq);
        System.out.println(prq.poll());
    }

}
