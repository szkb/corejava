//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.study.basicknowledge.module;

import java.util.stream.Stream;

public interface Node<T> {
    void add(T var1, String[] var2, int var3);

    Stream<T> find(String[] var1, int var2);

    Stream<T> findAll();
}
