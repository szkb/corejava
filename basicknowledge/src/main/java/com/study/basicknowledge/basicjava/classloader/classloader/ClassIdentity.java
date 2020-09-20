package com.study.basicknowledge.basicjava.classloader.classloader;

import com.study.basicknowledge.basicjava.classloader.customclassloader.MyClassLoader;
import java.lang.reflect.Method;


public class ClassIdentity {

	public static void main(String[] args) {
		new ClassIdentity().testClassIdentity();
	}
	
	public void testClassIdentity() {
		String classDataRootPath = "C:\\Documents and Settings\\Administrator\\workspace\\Classloader\\classData";
		FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
		FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);

		MyClassLoader mcl = new MyClassLoader();
		MyClassLoader mc2 = new MyClassLoader();
		String className = "com.study.basicknowledge.basicjava.classloader.com.example.Sample";
		try {
			Class<?> class1 = mcl.loadClass(className);
			Object obj1 = class1.newInstance();
			Class<?> class2 = mc2.loadClass(className);
			Object obj2 = class2.newInstance();
			Method setSampleMethod = class1.getMethod("setSample", Object.class);
			setSampleMethod.invoke(obj1, obj2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
