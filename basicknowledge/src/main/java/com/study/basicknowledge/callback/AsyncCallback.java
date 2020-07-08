package com.study.basicknowledge.callback;

public interface AsyncCallback<T> {
    void execute(T t) throws InterruptedException;
}
