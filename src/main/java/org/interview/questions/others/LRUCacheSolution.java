package org.interview.questions.others;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheSolution {
    private int capacity;

    private LinkedHashMap<Integer, Integer> map;

    public LRUCacheSolution(int capacity){
        this.capacity = capacity;
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCacheSolution.this.capacity;
            }
        };
    }

    public int get(int key){
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int val){
        map.put(key, val);
    }

    public static void main(String[] args) {
        LRUCacheSolution lruCache = new LRUCacheSolution(3);
        lruCache.put(1,1);
        System.out.println(lruCache.get(1));
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(3,3);
        lruCache.put(4,4);



        System.out.println(lruCache.get(3));

    }
}
