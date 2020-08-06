//package com.study.service.distributedlock.database;
//
//import java.sql.Connection;
//
///**
// * @author hangwu
// * @date 2020/6/15 11:32
// */
//public class DataBaseLockTest {
//
//    public boolean lock(){
//        Connection.setAutoCommit(false);
//        while (true) {
//            try {
//                result = select * from MethodLock where methodName = 'xxxx' for update;
//                if (result == null) {
//                    return false;
//                }
//            } catch (Exception e) {
//
//            }
//            sleep(1000);
//        }
//        returnType false;
//    }
//}
