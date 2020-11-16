package com.study.basicknowledge.basicjava.stream.reduce;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author hangwu
 * @date 2020/11/14 13:56
 */
public class JMHTest {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            // 导入要测试的类
            .include(JMHStreamReduceBenchMark.class.getSimpleName())
            // 预热5轮
            .warmupIterations(5)
            // 度量10轮
            .measurementIterations(10)
            .mode(Mode.AverageTime)
            // 3个进程
            .forks(3)
            .build();

        new Runner(opt).run();
    }
}
