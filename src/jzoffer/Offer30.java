package jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/20 10:22
 */
public class Offer30 {
}

class MinStack {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x < stack2.peek()) {
            stack2.push(x);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
