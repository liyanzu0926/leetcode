package niuke.top100;

import java.util.*;


class Solution_1 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public Solution_1(int capacity) {
        // write code here
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        // write code here
        return super.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        // write code here
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > capacity;
    }
}


class Solution_2 {
    class DLinkedNode<K, V> {
        private K key;
        private V value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        ;

        public DLinkedNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private DLinkedNode head;
    private DLinkedNode tail;
    private int size;

    public Solution_2(int capacity) {
        // write code here
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        // write code here
        DLinkedNode<Integer, Integer> node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        // write code here
        DLinkedNode<Integer, Integer> node = map.get(key);
        if (node == null) {
            DLinkedNode<Integer, Integer> newNode = new DLinkedNode<>(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > this.capacity) {
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    // 插入
    public void addToHead(DLinkedNode node) {
        node.next = this.head.next;
        node.next.pre = node;
        node.pre = this.head;
        this.head.next = node;

    }

    // 删除
    public DLinkedNode removeTail() {
        DLinkedNode p = this.tail.pre;
        this.tail.pre.pre.next = this.tail;
        this.tail.pre = this.tail.pre.pre;
        return p;
    }

    // 将该结点移到头部
    public void moveToHead(DLinkedNode node) {
        // 把node从原位置摘除
        node.next.pre = node.pre;
        node.pre.next = node.next;
        // 将node移到表头
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}


