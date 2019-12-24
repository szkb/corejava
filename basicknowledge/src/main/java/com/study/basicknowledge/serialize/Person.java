package com.study.basicknowledge.serialize;

import java.io.Serializable;
public class Person implements Serializable {
    private static final long serialVersionUID = 12345678901L;
    public int id;

    public Person(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Person: " + id + " " ;
    }
}