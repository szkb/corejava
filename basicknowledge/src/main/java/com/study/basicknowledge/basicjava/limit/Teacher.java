package com.study.basicknowledge.basicjava.limit;

/**
 * @author hangwu
 * @date 2020/10/30 18:00
 */
public class Teacher {

    private String getName() {
        return "hello";
    }

    protected String getAnswer() {
        return "world";
    }

    String getHobby() {
        return "OK";
    }

    private AddressName addressName;

    public AddressName getAddressName() {
        return addressName;
    }

    public void setAddressName(AddressName addressName) {
        this.addressName = addressName;
    }
}
