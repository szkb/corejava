package com.study.basicknowledge.serialize.protostuff;

import io.protostuff.Tag;

/**
 * @author hangwu
 * @date 2020/9/2 11:33
 */
public class School {

    public School(String schoolRank) {
        this.schoolRank = schoolRank;
    }

//    @Tag(1)
    private String schoolRank;

    public String getSchoolRank() {
        return schoolRank;
    }

    public void setSchoolRank(String schoolRank) {
        this.schoolRank = schoolRank;
    }
}
