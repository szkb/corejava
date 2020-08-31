package com.study.database.mybatis.cache;

import com.study.database.mybatis.User;
import com.study.database.mybatis.dao.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author gacl 测试一级缓存
 */
public class TestOneLevelCache {

    /*
     * 一级缓存: 也就Session级的缓存(默认开启)
     */
    @Test
    public void testCache1() {
        SqlSession session = MyBatisUtil.getSqlSession();
        String statement = "userMapper.getUser";
        User user = session.selectOne(statement, 1);
        System.out.println(user);

        /*
         * 一级缓存默认就会被使用
         */
        user = session.selectOne(statement, 1);
        System.out.println(user);
        session.close();
        /*
         1. 必须是同一个Session,如果session对象已经close()过了就不可能用了
         */
        session = MyBatisUtil.getSqlSession();
        user = session.selectOne(statement, 1);
        System.out.println(user);

        /*
         2. 查询条件是一样的
         */
        user = session.selectOne(statement, 2);
        System.out.println(user);

        /*
         3. 没有执行过session.clearCache()清理缓存
         */
        //session.clearCache();
        user = session.selectOne(statement, 2);
        System.out.println(user);

        /*
         4. 没有执行过增删改的操作(这些操作都会清理缓存)
         */
        User user1 = new User();
        user1.setId(2);
        user1.setAge(27);
        user1.setUser_name("kobe");
        session.update("userMapper.updateUser", user1);
        user = session.selectOne(statement, 2);
        System.out.println(user);

    }
}