package com.study.redis.distributedlock.database;

import java.sql.*;
import org.springframework.util.StringUtils;

public class main {

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
            //要执行的SQL语句
//            String sql = "select * from database_lock";
//
//            //3.ResultSet类，用来存放获取的结果集！！
//            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("-----------------");
//            System.out.println("执行结果如下所示:");
//            System.out.println("-----------------");
//            System.out.println("名称" + "\t" + "地址");
//            System.out.println("-----------------");
//
//            String address = null;
//
//            String name = null;
//            for (int i = 0; i < 10; i++) {
//                int finalI = i;
//                new Thread(() -> {
//                    try {
//                        boolean getDistributedLock = getDistributedLock(con, statement);
//                        if (!getDistributedLock) {
//                            System.out.println("hello world " + finalI);
//                        }
//                        Thread.sleep(1000);
//                        deleteDistributedLock(con, statement);
//                    } catch (SQLException | InterruptedException e) {
//                        System.out.println(Thread.currentThread().getName() + "error");
////                        e.printStackTrace();
//                    }
//                }).start();
//            }
//            Thread.sleep(3000);
//            deleteDistributedLock(con, statement);
//            while(rs.next()){
//                //获取sname这列数据
//                name = rs.getString("Name");
//                //获取address这列数据
//                address = rs.getString("CountryCode");
//                //输出结果
//                System.out.println(name + "\t" + address);
//
//            }
//            rs.close();
            for (int i = 0; i < 2; i++) {
                int finalI = i;
                new Thread(() -> {
                    try {
                        boolean result = false;
                        if (finalI % 2 != 0) {
                            result = getOptimisticLock(con, statement);
                        } else {
                            result = getOptimisticLock(con1, statement);
                        }
                        if (result) {
                            System.out.println("hello world");
                        } else {
                            System.out.println("getOptimisticLock fail");
                        }
                    } catch (Exception e) {
                        System.out.println("getOptimisticLock fail");
                        e.printStackTrace();
                    }
                }).start();
            }
            Thread.sleep(2000);
//            con.close();


        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            System.out.println("数据库数据成功获取！！");

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

    private static boolean getOptimisticLock(Connection con,Statement statement) throws SQLException {
        String sqlQuery = "select * from database_lock where id = 5";
        Statement statement1 = con.createStatement();
        ResultSet resultSet = statement1.executeQuery(sqlQuery);
        String version = null;
        while (resultSet.next()) {
            version = resultSet.getString("version");
        }
        String sql = getSQL(version);
        if (StringUtils.isEmpty(sql)) {
            return false;
        }
        int result = statement1.executeUpdate(sql);
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

    private static boolean getPessimisticLock(Connection con,Statement statement) throws Exception {
        String sqlQuery = "select * from database_lock where id = 5 for update";
        Statement statement1 = con.createStatement();
        ResultSet resultSet = statement1.executeQuery(sqlQuery);

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ":" + resultSet);
        String version = null;
        String resource = null;
        while (resultSet.next()) {
            version = resultSet.getString("version");
            resource = resultSet.getString("resource");
        }

        String sql = getPessimisticSQL(version, resource);
        if (StringUtils.isEmpty(sql)) {
            return false;
        }
        int result = statement1.executeUpdate(sql);
        con.commit();
        System.out.println(Thread.currentThread().getName() + ":" + result);
        return result != 0;
    }
    private static String getPessimisticSQL(String version, String resource) {
        if (StringUtils.isEmpty(version)) {
            return null;
        }
        return String.format("update database_lock set resource = %s", Integer.parseInt(resource) + 1);
    }
}