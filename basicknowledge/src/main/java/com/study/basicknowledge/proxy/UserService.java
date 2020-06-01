package com.study.basicknowledge.proxy;

public interface UserService {
    public void select();
    public void update();
}

class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询 selectById");
    }
    @Override
    public void update() {
        System.out.println("更新 update");
    }
}
