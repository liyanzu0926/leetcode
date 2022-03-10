package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Lc155 {
    public static void main(String[] args) {

    }
}

class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minValue;

    public MinStack() {
        stack = new LinkedList<>();
        minValue = new LinkedList<>();
        minValue.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        minValue.push(Math.min(minValue.peek(), val));
        stack.push(val);
    }

    public void pop() {
        minValue.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}
