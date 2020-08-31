package com.study.concurrence.producerandconsumer;

public class Data {
    private int id;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Data(int id, int num) {
        this.id = id;
        this.num = num;
    }

    public Data() {

    }
}