//package com.study.springboot.beanlifecycle.beanpostprocessor;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//@SpringBootApplication
//@MapperScan("com.lx.mapper")
//public class MlxcApplication {
//    public static void main(final String[] args) {
//        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(MlxcApplication.class, args)) {
//            HelloServiceTest helloService = applicationContext.getBean(HelloServiceTest.class);
//            helloService.testSayHello();
//        }
//    }
//}