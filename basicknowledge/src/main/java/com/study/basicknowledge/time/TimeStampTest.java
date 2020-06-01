package com.study.basicknowledge.time;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2020/4/26 14:04
 */
public class TimeStampTest {

    class Product {
        private List<String> nameList;

        private Timestamp timestamp;

        public List<String> getNameList() {
            return nameList;
        }

        public void setNameList(List<String> nameList) {
            this.nameList = nameList;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }
    }

   Timestamp parseTimestamp(Timestamp timestamp, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date parsedDate = dateFormat.parse(timestamp.toString());
        return new Timestamp(parsedDate.getTime());
    }

    @Test
    public void test() throws ParseException {
        Product productTemp = new Product();
        productTemp.setTimestamp(null);
//        final long timeSec = 10 * 1000;
//        final long timeNow = System.currentTimeMillis();
//        final long timeBefore = System.currentTimeMillis() - timeSec;
//        Timestamp timestamp1 = new Timestamp(timeBefore);
//        Timestamp timestamp2 = new Timestamp(timeNow);
//        System.out.println(timestamp1.getTime());
//        System.out.println(timestamp2.getTime());
//        System.out.println(timestamp2.getTime() - timestamp1.getTime());

        Product product = new Product();
        product.setTimestamp(new Timestamp(System.currentTimeMillis() - 100000));
        Timestamp timestamp3 = product.getTimestamp();
        product = productTemp;
        System.out.println(timestamp3);
        System.out.println(product.getTimestamp());
    }

    @Test
    public void test1() {
        Product product = new Product();
        product.setNameList(new ArrayList<>());
        product.getNameList().add("world");
        product.getNameList().stream().findFirst().ifPresent(System.out::println);
    }

    @Test
    public void test2() {
        final long timeSec = 10 * 1000;
        final long timeNow = System.currentTimeMillis();
        final long timeBefore = System.currentTimeMillis() - timeSec;
        Timestamp timestamp1 = new Timestamp(timeBefore);
        Timestamp timestamp2 = new Timestamp(timeNow);
        System.out.println(timestamp1.getTime());
        System.out.println(timestamp2.getTime());
        System.out.println(timestamp2.getTime() - timestamp1.getTime());
    }
}
