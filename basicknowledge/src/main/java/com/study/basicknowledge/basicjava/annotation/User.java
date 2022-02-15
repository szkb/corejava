package com.study.basicknowledge.basicjava.annotation;

import lombok.Data;

@Data
public class User implements Cloneable {

    @Name(value = "wtj")
    public String name;

    public String age;

    @Sex(gender = Sex.GenderType.Male)
    public String sex;

    public Company company;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public User deepCopy() {
        User newObj = new User();
        newObj.name =  this.name;
        newObj.age = this.age;
        newObj.company = this.company.deepCopy();
        return newObj;
    }
}
