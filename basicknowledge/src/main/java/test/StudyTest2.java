package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * @author hangwu
 * @date 2022/4/28 10:19
 */
public class StudyTest2 {

    @Test
    public void test() {
        boolean a = true;
        boolean b = false;
        boolean c = false;
        System.out.println(a || b && c);
    }

    @Test
    public void test2() {
        List<String> ans = new ArrayList<>();
        ans.add("1");
        ans.add("2");
        System.out.println(ans.remove("2"));
    }

    @Test
    public void test3() {
        BigDecimal ans = new BigDecimal(3.4);
        System.out.println(ans.intValue());
    }

    @Test
    public void test4() {
        Book book = new Book(1, 100);
        Book book2 = new Book(1, 2);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book2);
        System.out.println(bookList.stream().collect(Collectors.toMap(Book::getNumber,
            Book::getPrice, (oldValue, newValue) -> oldValue)));
    }

    static class Book {
        int number;
        int price;

        public Book (int number, int price) {
            this.number = number;
            this.price = price;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    @Test
    public void test5() {
        List<String> ans = new ArrayList<>(0);
        for (int i = 0; i < 10; i++) {
            ans.add("hello");
            ans.add("world");
        }
        System.out.println(ans);
    }

    @Test
    public void test6() {
        Map<String, String> map = new HashMap<>();
        map.put("Shoes", "hello");
        System.out.println(map);

        String price = map.compute("Shoes", (key, value) -> key + value);
        System.out.println(price);
    }

    @Test
    public void test7() {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("hello");
        ans.add(temp);
        System.out.println(ans);
        ans.forEach(item -> item.removeIf(j -> j.equals("hello")));
        System.out.println(ans);

        System.out.println(temp.isEmpty());
        System.out.println(ans.isEmpty());
    }

    @Test
    public void test8() {
        int a = 1;
        System.out.println(Long.valueOf(a));
        System.out.println(String.valueOf(null));
    }
}
