package com.study.springboot.ioc.set;

import org.springframework.stereotype.Service;

@Service
public class StoneAxe implements Axe{
 
	@Override
	public String chop() {
		return "石斧砍柴好慢啊!!!";
	}
 
}