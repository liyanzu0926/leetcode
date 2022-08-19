package jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/19 11:15
 */
public class Offer59_2 {
}

class MaxQueue59_2_1 {

    Deque<Integer> queue1;
    Deque<Integer> queue2;

    public MaxQueue59_2_1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public int max_value() {
        return queue2.isEmpty() ? -1 : queue2.getFirst();
    }

    public void push_back(int value) {
        queue1.offer(value);
        // 维护queue2为递增队列
        while (!queue2.isEmpty() && queue2.getLast() < value) {
            queue2.pollLast();
        }
        queue2.offerLast(value);
    }

    public int pop_front() {
        if (queue1.isEmpty()) {
            return -1;
        }
        int value = queue1.poll();
        if (queue2.getFirst().equals(value)) {
            queue2.pollFirst();
        }
        return value;
    }
}
