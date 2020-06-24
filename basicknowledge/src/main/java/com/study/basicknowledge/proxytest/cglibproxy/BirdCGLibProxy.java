package com.study.basicknowledge.proxytest.cglibproxy;
 
 
import com.study.basicknowledge.proxytest.Bird;
import java.lang.reflect.Method;
 
 
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/** 
*
* @author hangwu
*/
public class BirdCGLibProxy {
	@Before
	public void init(){
		//设置将cglib生成的代理类字节码生成到指定位置
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:/Temp/code/cglibbird");
	}
	/**
	 * 利用Enhancer类生成代理类
	 */
	@Test
	public void test(){
		Enhancer enhancer = new Enhancer();  
		enhancer.setSuperclass(Bird.class);
		enhancer.setCallback(new MyMethodInterceptor());
		Bird bird = (Bird)enhancer.create();
		//执行 fly 方法
		bird.fly();
	}
	/**
	 * 实现MethodInterceptor接口，定义方法的拦截器
	 *
	 */
	public static class MyMethodInterceptor implements MethodInterceptor {
	    @Override
		public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
	        System.out.println("Before:" + method);
//	        Object object = method.invoke(new Bird(), arg);
//			Object object = proxy.invoke(obj, arg);
	        Object object = proxy.invokeSuper(obj, arg);
	        System.out.println("After:" + method); 
	        return object;
	    }
	}
}