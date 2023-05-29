package com.study.basicknowledge.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author hangwu
 * @date 2020/3/12 19:13
 */

@Data
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Room {

//    @JsonProperty("roomPrice")
    private double price;

    @JsonProperty("roomSize")
    private Long size;

    private String address;

    private boolean beautiful;

    private List<String> temp;


    @Override
    public String toString() {
        return "Room{" +
            "price=" + price +
            ", size=" + size +
            ", address='" + address + '\'' +
            '}';
    }
}
