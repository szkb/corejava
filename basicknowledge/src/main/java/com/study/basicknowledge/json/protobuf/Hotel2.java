package com.study.basicknowledge.json.protobuf;

import io.protostuff.Tag;

/**
 * @author hangwu
 * @date 2023/4/17 20:00
 */
public class Hotel2 {
    /**
     * 产品id
     */
    @Tag(1)
    private long productId;

    /**
     * 酒店id
     */
    @Tag(2)
    private long hotelId;

    /**
     * 城市id
     */
    @Tag(3)
    private int cityId;

    /**
     * 业务配置的房型ID
     */
    @Tag(4)
    private Long businessRoomId;
}
