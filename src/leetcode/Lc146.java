package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lc146 {
    public static void main(String[] args) {
        LRUCache_1 lruCache = new LRUCache_1(2);
        lruCache.put(2, 6);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.print();
    }
}

class LRUCache_1 {
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache_1(int capacity) {
        this.capacity = capacity;
        int temp = (int) (capacity / 0.75 + 1);
        map = new LinkedHashMap<>(temp);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Integer value = map.remove(key);
        map.put(key, value);
        return value;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() >= this.capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            Map.Entry<Integer, Integer> next = iterator.next();
            map.remove(next.getKey());
        }
        map.put(key, value);
    }

    public void print() {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getKey());
        }
    }
}

class LRUCache_2 extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache_2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
