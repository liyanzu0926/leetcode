package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc84 {
    public static void main(String[] args) {
        int[] heights = {2, 0, 2};
        System.out.println(new Solution84_3().largestRectangleArea(heights));
    }
}

/**
 * 暴力
 */
class Solution84_1 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxres = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                if (heights[j] >= heights[i]) {
                    sum += heights[i];
                } else {
                    maxres = Math.max(maxres, sum);
                    sum = 0;
                }
            }
            maxres = Math.max(maxres, sum);
        }
        return maxres;
    }
}

/**
 * 单调栈 + 哨兵
 */
class Solution84_2 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int area = 0;
        for (int i = 1; i < len; i++) {
            while (heights[stack.peek()] > heights[i]){
                int height = heights[stack.pop()];
                int weith = i - stack.peek() - 1;
                area = Math.max(area, height * weith);
            }
            stack.push(i);
        }
        return area;
    }
}

/**
 * 单调栈
 */
class Solution84_3 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        int area = 0;
        for (int i = 0; i < len; i++) {
            area = Math.max(area, (right[i] - left[i] - 1) * heights[i]);
        }
        return area;
    }
}
