package com.study.springboot.ioc.constructor;

import com.study.springboot.ioc.set.Axe;
import com.study.springboot.ioc.set.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Japanese implements Person {

	private Axe axe;

	//构造注入所需的带参数构造器
	@Autowired
	public Japanese(Axe axe) {
		this.axe = axe;
	}

	@Override
	public void useAxe() {
		System.out.println(axe.chop());
	}

	@Override
	public String toString() {
		return "Japanese{" +
			"axe=" + axe +
			'}';
	}
}