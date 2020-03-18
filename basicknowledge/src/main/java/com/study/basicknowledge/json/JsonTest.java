package com.study.basicknowledge.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/3/12 19:12
 */
public class JsonTest {

    private String print(String name) {
        return "hello";
    }

    private int print(int name) {
        return 0;
    }

    @Test
    public void test() throws IOException {
        Room room = new Room();
        room.setPrice(100);
        room.setSize(100);
        room.setAddress("hello world");
        room.setBeautiful(true);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = new ObjectMapper().writeValueAsString(room);
        System.out.println(jsonString);
        Room temp = mapper.readValue(jsonString, Room.class);
        System.out.println(temp);
    }

    @Test
    public void test2() {
        Room room = new Room();
        room.setTemp(new ArrayList<>());
        room.setTemp(Collections.singletonList("hello world"));
        System.out.println(room.getTemp());

        ArrayList<String> stringArrayList = (ArrayList<String>) room.getTemp();
        System.out.println(stringArrayList);
//        System.out.println(Collections.singletonList("hello world"));
//        System.out.println(Arrays.asList("hello world"));
    }

    @Test
    public void test3() {
//        System.out.println(Integer.parseInt(null));
        System.out.println(Optional.ofNullable(null).orElse(16));
        System.out.println();
    }

}
