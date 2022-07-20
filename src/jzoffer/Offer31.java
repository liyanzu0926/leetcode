package jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author lyz
 * @Date 2022/7/20 11:08
 */
public class Offer31 {
}

class Solution31_1 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len <= 1) return true;
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
