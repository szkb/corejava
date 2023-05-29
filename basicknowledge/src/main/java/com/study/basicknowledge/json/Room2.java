package com.study.basicknowledge.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 * @author hangwu
 * @date 2023/4/17 19:51
 */
@Data
public class Room2 {

    private double price;

    @JsonProperty("roomSize")
    private Integer size;

    private String address;

    private boolean beautiful;

    private List<String> temp;
}
