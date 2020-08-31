//package com.study.database.mybatis;
//
//import java.io.InputStream;
//import org.apache.ibatis.session.*;
//
///**
// * @author hangwu
// * @date 2020/8/18 20:41
// */
//public class MyBatisUtil {
//
//    public static SqlSession getSqlSession() {
//        String resource = "conf.xml";
//        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
//        //构建sqlSession的工厂
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
//        //Reader reader = Resources.getResourceAsReader(resource);
//        //构建sqlSession的工厂
//        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        //创建能执行映射文件中sql的sqlSession
//        return sessionFactory.openSession();
//    }
//}
