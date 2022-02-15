package com.study.basicknowledge.basicjava.stream.reduce;

/**
 * @author hangwu
 * @date 2021/11/17 15:15
 */
public enum SearchType {
    /**
     * 中转联程
     */
    AIRLINE_TRANSFER(1, "AirlineTransfer", 0),

    /**
     * 中转推荐 单+单政策
     */
    CTRIP_TRANSFER(2, "CtripTransfer", 0),

    /**
     * 空铁
     */
    FLIGHT_X_TRAIN(4, "FlightXTrain", 96);

    private int value;
    private String message;
    private int transportRecommendLevel;

    SearchType(int value, String message, int transportRecommendLevel) {
        this.value = value;
        this.message = message;
        this.transportRecommendLevel = transportRecommendLevel;
    }
}
