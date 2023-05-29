package com.study.basicknowledge.json.protobuf;

import io.protostuff.Tag;
import lombok.Data;

/**
 * @author hangwu
 * @date 2023/4/17 19:59
 */
@Data
public class Hotel {
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
    private Integer businessRoomId;
}
