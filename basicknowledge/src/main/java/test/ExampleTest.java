package test;

import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/3/24 20:50
 */
public class ExampleTest {

    private void work(String name) {
        System.out.println(name + "working");
    }

    @Test
    public void test() {
        ExampleTest exampleTest = new ExampleTest();
        exampleTest.work(getName());
    }

    private String getName() {
        return null;
    }

}
