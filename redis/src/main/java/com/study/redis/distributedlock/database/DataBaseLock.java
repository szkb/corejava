package com.study.redis.distributedlock.database;

import java.sql.*;
import org.springframework.util.StringUtils;

public class DataBaseLock {

    public static void main(String[] args) throws Exception{
        //声明Connection对象
        // 给悲观锁使用，两个不同的连接，模拟两个不同的进程。
        Connection con;
        Connection con1;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名studb
        String url = "jdbc:mysql://localhost:3306/distributedlock?serverTimezone=GMT&useSSL=false";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";

        //遍历查询结果集
        try {

            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);

            con1 = DriverManager.getConnection(url, user, password);
            con1.setAutoCommit(false);
            if (!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();

//            rs.close();
            for (int i = 0; i < 2; i++) {
                int finalI = i;
                new Thread(() -> {
                    try {
                        boolean result = false;
                        if (finalI % 2 != 0) {
                            result = getPessimisticLock(con);
                        } else {
                            result = getPessimisticLock(con1);
                        }
                        if (result) {
                            System.out.println("hello world");
                        } else {
                            System.out.println("getOptimisticLock fail");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("catch getOptimisticLock fail");
                    }
                }).start();
            }
            Thread.sleep(2000);
            con.close();
            con1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean getDistributedLock(Connection con, Statement statement) throws SQLException {
        String sql = "INSERT INTO database_lock(resource, description, version) VALUES (14,'lock2', 1)";
        boolean resultSet = statement.execute(sql);
        return resultSet;
    }

    private static void deleteDistributedLock(Connection con, Statement statement) throws SQLException {
        String sql = "DELETE FROM database_lock WHERE resource=12";
        boolean resultSet = statement.execute(sql);
        System.out.println(resultSet);
    }

    private static boolean getOptimisticLock(Connection con) throws SQLException {
        String sqlQuery = "select * from database_lock where id = 5";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        String version = null;
        while (resultSet.next()) {
            version = resultSet.getString("version");
        }
        String sql = getSQL(version);
        if (StringUtils.isEmpty(sql)) {
            return false;
        }
        int result = statement.executeUpdate(sql);
        con.commit();
        System.out.println(Thread.currentThread().getName() + ":" + result);
        return result != 0;
    }

    private static String getSQL(String version) {
        if (StringUtils.isEmpty(version)) {
            return null;
        }
        return String.format("update database_lock set resource = %s, version = %s where version = %s",
            Integer.parseInt(version) + 1,  Integer.parseInt(version) + 1, version);
    }

    private static boolean getPessimisticLock(Connection con) throws Exception {
        try {
            String sqlQuery = "select * from database_lock where id = 5 for update";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            String resource = null;
            while (resultSet.next()) {
                resource = resultSet.getString("resource");
            }

            String sql = getPessimisticSQL(resource);
            if (StringUtils.isEmpty(sql)) {
                return false;
            }
            int result = statement.executeUpdate(sql);
            con.commit();
            System.out.println(Thread.currentThread().getName() + ":" + result);
            return result != 0;
        } catch (Exception e) {
            return false;
        }
    }
    private static String getPessimisticSQL(String resource) {
        if (StringUtils.isEmpty(resource)) {
            return null;
        }
        return String.format("update database_lock set resource = %s", Integer.parseInt(resource) + 1);
    }
}