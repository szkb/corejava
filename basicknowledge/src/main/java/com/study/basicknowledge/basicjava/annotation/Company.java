package com.study.basicknowledge.basicjava.annotation;

import lombok.Data;

/**
 * @author hangwu
 * @date 2022/1/6 16:17
 */
@Data
public class Company {
    private String address;
    private String tel;

    public Company deepCopy() {
        Company newObj = new Company();
        newObj.address = this.address;
        newObj.tel = this.tel;
        return newObj;
    }
}
