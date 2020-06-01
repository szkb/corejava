package com.study.basicknowledge.proxy.cgib;
 
 
import java.lang.reflect.Method;
 
 
import org.junit.Before;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/** 
*
* @author xxj 
*/
public class ProxyCGLibTest {
	@Before
	public void init(){
		//设置将cglib生成的代理类字节码生成到指定位置
//		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:/Temp/code/cglib");
		//该设置用于输出jdk动态代理产生的类
//		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
	}
	/**
	 * 利用Enhancer类生成代理类
	 */
	@Test
	public void test(){
		Enhancer enhancer = new Enhancer();  
		enhancer.setSuperclass(UserServiceImpl.class);  
		enhancer.setCallback(new MyMethodInterceptor());  
		UserServiceImpl userService = (UserServiceImpl)enhancer.create();
		//执行 add 方法
		userService.add();
	}
	/**
	 * 实现MethodInterceptor接口，定义方法的拦截器
	 *
	 */
	public static class MyMethodInterceptor implements MethodInterceptor {
	    @Override
		public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
	        System.out.println("Before:" + method);
//	        Object object = method.invoke(new UserServiceImpl(), arg);
	        Object object = proxy.invokeSuper(obj, arg);
	        System.out.println("After:" + method); 
	        return object;
	    }
	}
	/**
	 * 定义业务逻辑
	 *
	 */
	public static class UserServiceImpl {  
	    public void add() {  
	        System.out.println("This is add service");  
	    }  
	}
}