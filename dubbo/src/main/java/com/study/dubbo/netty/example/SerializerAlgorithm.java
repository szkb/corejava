package com.study.dubbo.netty.example;

public interface SerializerAlgorithm {
    //json序列化标识，如果你有其他的序列化方式可以在这注明标识，类似上面的登录指令
    byte JSON = 1;
}