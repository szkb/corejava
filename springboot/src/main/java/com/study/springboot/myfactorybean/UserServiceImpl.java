package com.study.springboot.myfactorybean;

public class UserServiceImpl implements IUserService {
	
	public UserServiceImpl(){
		System.out.println("--被实例化了--");
	}

	@Override
	public void doSome() {
		System.out.println("UserServiceImpl 。。。 被执行了");
	}

}