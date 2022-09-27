package jzofferⅡ;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/27 10:41
 */
public class Offer031 {
}

class LRUCache031_1 extends LinkedHashMap<Integer, Integer> {

    int capacity;

    public LRUCache031_1(int capacity) {
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
        return this.size() > capacity;
    }
}

class LRUCache031_2 {

    // 双链表
    class DLinkedList<K, V> {
        K key;
        V value;
        DLinkedList prior;
        DLinkedList next;

        public DLinkedList() {
        }

        public DLinkedList(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer, DLinkedList> map;
    private DLinkedList head;
    private DLinkedList tail;

    public LRUCache031_2(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new DLinkedList<>();
        this.tail = new DLinkedList<>();
        head.next = tail;
        tail.prior = head;
    }

    public int get(int key) {
        DLinkedList<Integer, Integer> node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedList<Integer, Integer> node = map.get(key);
        if (node == null) {
            node = new DLinkedList<>(key, value);
            map.put(key, node); // 插入map
            addToHead(node); // 插入链表
            size++;
            if (size > capacity) {
                DLinkedList<Integer, Integer> tail = removeTail(); // 从链表中删除
                map.remove(tail.key); // 从map中删除
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedList node) {
        node.next = head.next;
        head.next.prior = node;
        head.next = node;
        node.prior = head;
    }

    private void moveToHead(DLinkedList node) {
        // 从原位置摘除
        removeNode(node);

        // 插入到头部
        addToHead(node);
    }

    private DLinkedList removeTail() {
        DLinkedList node = tail.prior;
        removeNode(node);
        return node;
    }

    private void removeNode(DLinkedList node) {
        node.prior.next = node.next;
        node.next.prior = node.prior;
    }

}

