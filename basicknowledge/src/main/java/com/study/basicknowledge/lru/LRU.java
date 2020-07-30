package com.study.basicknowledge.lru;

import java.util.LinkedHashMap;


public class LRU<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 1L;

    private static final String TEST_STRING = "abcdefghijkl";

    public LRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return size() > 6;
    }

    public static void main(String[] args) {
        LRU<Character, Integer> lru = new LRU<Character, Integer>(16, 0.75f, true);
        for (int i = 0; i < TEST_STRING.length(); i++) {
            lru.put(TEST_STRING.charAt(i), i);
        }
        System.out.println("LRU中key为h的Entry的值为： " + lru.get('h'));
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
    }
}