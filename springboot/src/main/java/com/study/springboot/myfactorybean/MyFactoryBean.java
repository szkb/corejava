package com.study.springboot.myfactorybean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<IUserService> {

	@Override
	public IUserService getObject() throws Exception {
		System.out.println("--IUserService实例化之前---");
		IUserService service = new UserServiceImpl();
		System.out.println("--IUserService实例化后---");
		return service;
	}

	@Override
	public Class<?> getObjectType() {
		return IUserService.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}