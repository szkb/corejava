package com.study.basicknowledge.basicjava.annotation;

import lombok.Data;

@Data
public class User {

    @Name(value = "wtj")
    public String name;

    public String age;

    @Sex(gender = Sex.GenderType.Male)
    public String sex;

}
