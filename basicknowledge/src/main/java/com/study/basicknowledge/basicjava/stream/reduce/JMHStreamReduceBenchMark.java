package com.study.basicknowledge.basicjava.stream.reduce;

import com.study.basicknowledge.basicjava.stream.reduce.ReduceBenchMark.User;
import java.math.BigDecimal;
import java.util.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class JMHStreamReduceBenchMark {

    private final List<ReduceBenchMark.User> userList = createUsers();

    public static void main(String[] args) throws RunnerException {

        Options options = new OptionsBuilder()
            .include(JMHStreamReduceBenchMark.class.getSimpleName()).threads(10)
            // 预热5轮
            .warmupIterations(15)
            // 度量10轮
            .measurementIterations(5)
            .forks(1).shouldFailOnError(true).shouldDoGC(true)
            .jvmArgs("-server").build();
        new Runner(options).run();
    }

    private List<ReduceBenchMark.User> createUsers() {
        List<ReduceBenchMark.User> users = new ArrayList<>();
        for (int i = 0; i <= 1000000; i++) {
            users.add(new ReduceBenchMark.User("John" + i, i, new BigDecimal(i)));
        }
        return users;
    }

//    @Benchmark
//    public Integer executeReduceOnParallelizedStream() {
//        return this.userList
//                .parallelStream()
//                .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
//    }
//
//    @Benchmark
//    public Integer executeReduceOnSequentialStream() {
//        return this.userList
//                .stream()
//                .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.getAge(), Integer::sum);
//    }

    @Benchmark
    public double getMoneySum() {
        return this.userList.stream().map(user -> Optional.ofNullable(user.getMoney()).orElse(BigDecimal.ZERO))
            .mapToDouble(BigDecimal::doubleValue).sum();
    }

    @Benchmark
    public double getMoneySumFilter() {
        return this.userList.stream().filter(user -> user.getMoney() != null).map(User::getMoney)
            .mapToDouble(BigDecimal::doubleValue).sum();
    }
}
