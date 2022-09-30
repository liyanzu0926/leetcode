package jzofferⅡ;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/30 13:41
 */
public class Offer037 {
}

class Solution037_1 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean alive = true;
            while (alive && asteroids[i] < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -asteroids[i];
                if (stack.peek() <= -asteroids[i]) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(asteroids[i]);
            }
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}
