package com.study.basicknowledge.serialize.protostuff;

import java.util.Arrays;

/**
 * Created by zhangzh on 2017/2/20.
 */
public class ProtoBufUtilTest {

    public static void main(String[] args) {

        Student student = new Student();
        student.setName("lance");
        student.setAge(28);
        student.setStudentNo("2011070122");

        School school = new School("1");
//        school.setSchoolRank("1");
        student.setSchool(school);

        byte[] serializerResult = ProtoBufUtil.serializer(student);

        System.out.println("serializer result:" + Arrays.toString(serializerResult));

        Student deSerializerResult = ProtoBufUtil.deserializer(serializerResult, Student.class);

        System.out.println("deSerializerResult:" + deSerializerResult.toString());
    }

}