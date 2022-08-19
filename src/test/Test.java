package test;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.getFirst());
        System.out.println(queue.getLast());
        System.out.println(queue.poll());
    }
}


