package com.study.basicknowledge.lru.mylru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hangwu
 * @date 2020/7/31 11:07
 */
public class MyLRUCache<K, V> {

    int capacity;

    Entry head;

    Entry tail;

    Map<K, Entry> map = new HashMap<>();

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        Entry newNode =  new Entry();
        newNode.value = value;
        if (map.size() == 0) {
            head = newNode;
            tail = newNode;
        }
        if (map.containsKey(key)) {
            map.put(key, newNode);
            afterInsertNode(newNode);
        } else {
            map.put(key, newNode);
            if (map.size() > capacity) {
                addToTail(head.after, newNode);
            } else {
                addToTail(head, newNode);
            }
        }
    }

    private void afterInsertNode(Entry newNode) {
        newNode.before.after = newNode.after;
        newNode.after.before = newNode.before;

        tail.after = newNode;
        newNode.before = tail;

        newNode.after = head;
        head.before = newNode;
    }

    private void addToTail(Entry head, Entry newNode) {
        tail.after = newNode;
        newNode.before = tail;
        head.before = newNode;
        newNode.after = head;
        tail = newNode;
    }

    private void deleteHeadNode() {
        head = head.after;
        tail.after = head;
    }

    public static void main(String[] args) {
        MyLRUCache cache = new MyLRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    private V get(K key) {
        Entry valueEntry = (Entry) map.get(key);
        transfer(valueEntry);
        return (V) valueEntry.value;
    }

    private void transfer(Entry entry) {
        if (map.size() == 2) {
            if (entry == tail) {
                return;
            }
            Entry temp = entry;
            head = entry.after;
            tail = head;

            head.after = tail;
            head.before = tail;

            tail.after = head;
            tail.before = head;
            return;
        }
        Entry temp = entry.after;
        head.after = temp;
        temp.before = head;

        tail.after = entry;
        entry.before = tail;

        entry.after = head;
        head.before = entry;

    }

}

class Entry<K, V> {
    K key;
    V value;
    Entry before;
    Entry after;
}
