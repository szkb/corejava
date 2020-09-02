package com.study.basicknowledge.serialize.protostuffbean;

import io.protostuff.*;
import io.protostuff.runtime.RuntimeSchema;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ProtostuffUtils {

    /**
     * 避免每次序列化都重新申请Buffer空间
     */
    private static LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
    /**
     * 缓存Schema
     */
    private static Map<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap<Class<?>, Schema<?>>();

    /**
     * 序列化方法，把指定对象序列化成字节数组
     *
     * @param obj
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T obj) {
        Class<T> clazz = (Class<T>) obj.getClass();
        Schema<T> schema = getSchema(clazz);
        byte[] data;
        try {
            data = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } finally {
            buffer.clear();
        }

        return data;
    }

    /**
     * 反序列化方法，将字节数组反序列化成指定Class类型
     *
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] data, Class<T> clazz) {
        Schema<T> schema = getSchema(clazz);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data, obj, schema);
        return obj;
    }

    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> clazz) {
        Schema<T> schema = (Schema<T>) schemaCache.get(clazz);
        if (schema == null) {
            //这个schema通过RuntimeSchema进行懒创建并缓存
            //所以可以一直调用RuntimeSchema.getSchema(),这个方法是线程安全的
            schema = RuntimeSchema.getSchema(clazz);
            if (schema == null) {
                schemaCache.put(clazz, schema);
            }
        }

        return schema;
    }

    public static void main(String[] args) {
        final User user1 = new User("aaa", 20);
        Group group = new Group();
        group.setId("1");
        group.setName("hello");
        group.setUser(null);

        byte[] bytes = ProtostuffUtils.serialize(group);
        System.out.println("序列化后: " + bytes.length);

        Group group1 = ProtostuffUtils.deserialize(bytes, Group.class);
        System.out.println("反序列化后: " + group1.getName());
        System.out.println(group1.getUser());

    }
}