//package com.study.basicknowledge.proxytest.jdkproxy;
//
//import java.lang.reflect.*;
//import java.lang.reflect.WeakCache.*;
//import java.security.AccessController;
//import java.security.PrivilegedAction;
//import java.util.Objects;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//import java.util.function.Supplier;
//import sun.misc.ProxyGenerator;
//import sun.reflect.CallerSensitive;
//import sun.reflect.Reflection;
//
///**
// * @author hangwu
// * @date 2020/6/3 19:29
// */
//public class Test {
//
//    @org.junit.Test
//    @CallerSensitive
//    public static Object newProxyInstance(ClassLoader loader,
//        Class<?>[] interfaces,
//        InvocationHandler h)
//        throws IllegalArgumentException
//    {
//        Objects.requireNonNull(h);
//
//        final Class<?>[] intfs = interfaces.clone();
//
//        // 获取代理类的关键方法
//        Class<?> cl = getProxyClass0(loader, intfs);
//
//        /*
//         * Invoke its constructor with the designated invocation handler.
//         */
//        try {
//            // .... 省略
//            // 反射获取指定构造器，此构造器的参数是constructorParams
//            final Constructor<?> cons = cl.getConstructor(constructorParams);
//            final InvocationHandler ih = h;
//            // 反射新建实例
//            return cons.newInstance(new Object[]{h});
//        }
//    }
//
//    public V get(K key, P parameter) {
//        Objects.requireNonNull(parameter);
//
//        // 清除过期缓存
//        expungeStaleEntries();
//
//        // 此处是将key(加载器)，refQueue（弱引用队列）包装成cacheKey
//        Object cacheKey = CacheKey.valueOf(key, refQueue);
//
//        // lazily install the 2nd level valuesMap for the particular cacheKey
//        ConcurrentMap<Object, Supplier<V>> valuesMap = map.get(cacheKey);
//        if (valuesMap == null) {
//            ConcurrentMap<Object, Supplier<V>> oldValuesMap
//                = map.putIfAbsent(cacheKey,
//                valuesMap = new ConcurrentHashMap<>());
//            if (oldValuesMap != null) {
//                valuesMap = oldValuesMap;
//            }
//        }
//
//        // 通过subKeyFactory创建subKey
//        Object subKey = Objects.requireNonNull(subKeyFactory.apply(key, parameter));
//        Supplier<V> supplier = valuesMap.get(subKey);
//        Factory factory = null;
//
//        while (true) {
//            if (supplier != null) {
//                // 执行这里的supplier方法，建议debug执行
//                V value = supplier.get();
//                if (value != null) {
//                    return value;
//                }
//            }
//        }
//    }
//
//    public synchronized V get() { // serialize access
//        // re-check
//        Supplier<V> supplier = valuesMap.get(subKey);
//        if (supplier != this) {
//            // something changed while we were waiting:
//            // might be that we were replaced by a CacheValue
//            // or were removed because of failure ->
//            // return null to signal WeakCache.get() to retry
//            // the loop
//            return null;
//        }
//        // else still us (supplier == this)
//
//        // create new value
//        V value = null;
//        try {
//            value = Objects.requireNonNull(valueFactory.apply(key, parameter));
//        } finally {
//            if (value == null) { // remove us on failure
//                valuesMap.remove(subKey, this);
//            }
//        }
//        // the only path to reach here is with non-null value
//        assert value != null;
//
//        // wrap value with CacheValue (WeakReference)
//        CacheValue<V> cacheValue = new CacheValue<>(value);
//
//        // put into reverseMap
//        reverseMap.put(cacheValue, Boolean.TRUE);
//
//        // try replacing us with CacheValue (this should always succeed)
//        if (!valuesMap.replace(subKey, this, cacheValue)) {
//            throw new AssertionError("Should not reach here");
//        }
//
//        // successfully replaced us with new CacheValue -> return the value
//        // wrapped by it
//        return value;
//
//
//        V value = null;
//        try {
//            // 执行valueFactory的apply方法
//            value = Objects.requireNonNull(valueFactory.apply(key, parameter));
//        } finally {
//            if (value == null) { // remove us on failure
//                valuesMap.remove(subKey, this);
//            }
//        }
//
//
//       // 生成字节流
//        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
//            proxyName, interfaces, accessFlags);
//        try {
//            // 通过字节流生成代理类
//            return defineClass0(loader, proxyName,
//                proxyClassFile, 0, proxyClassFile.length);
//        }
//
//
//        private Object createHelper() {
//
//            // KEY_FACTORY生成key，可以不用细究
//            Object key = KEY_FACTORY.newInstance(this.superclass != null ? this.superclass.getName() : null, ReflectUtils.getNames(this.interfaces), this.filter == ALL_ZERO ? null : new WeakCacheKey(this.filter), this.callbackTypes, this.useFactory, this.interceptDuringConstruction, this.serialVersionUID);
//
//            Object result = super.create(key);
//            return result;
//        }
//
//
//        public Object get(AbstractClassGenerator gen, boolean useCache) {
//            if (!useCache) {
//                return gen.generate(this);
//            } else {
//                // 第一次执行这里，generatedClasses实际上是一个LoadingCache
//                Object cachedValue = this.generatedClasses.get(gen);
//                return gen.unwrapCachedValue(cachedValue);
//            }
//        }
//    }
//}
//
//}
