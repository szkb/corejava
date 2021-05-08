package com.study.basicknowledge.basicjava.enumtest;

/**
 * @author xkliu
 * @date 2018/12/25
 */
public enum MemberLevelEntity {
    /**
     * 匿名用户
     */
    NA(0),
    /**
     * 普通会员
     */
    Normal(1),
    /**
     * 金牌会员
     */
    Gold(2),
    /**
     * 白金会员
     */
    Platina(3),
    /**
     * 钻石会员
     */
    Diamond(4),
    /**
     * 金钻会员
     */
    GoldDiamond(5),
    /**
     * 黑钻会员
     */
    BlackDiamond(6);

    private int value;

    MemberLevelEntity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
