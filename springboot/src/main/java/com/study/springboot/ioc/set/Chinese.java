package com.study.springboot.ioc.set;

public class Chinese implements Person {
	private Axe axe1;
	private String name;
 
	// 设值注入所需的setter方法
	public void setAxe(Axe axe) {
		this.axe1 = axe;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	// 实现Person接口的userAxe方法
	@Override
	public void useAxe() {
		// 调用axe的chop方法，表明Person对象依赖于Axe对象
		System.out.println("我是"+name+"用"+axe1.chop());
	}

	public Axe getAxe() {
		return axe1;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Chinese{" +
			"axe=" + axe1 +
			", name='" + name + '\'' +
			'}';
	}
}