package niuke.top100;

import java.util.*;

/**
 * dp
 */
class BM77_1 {

    public int longestValidParentheses(String s) {
        // write code here
        int len = s.length();
        int max = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

/**
 * 栈
 */
class BM77_2 {

    public int longestValidParentheses(String s) {
        // write code here
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}

/**
 * 双指针
 */
class BM77_3 {

    public int longestValidParentheses(String s) {
        // write code here
        int left = 0;
        int right = 0;
        int len = s.length();
        int maxlen = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlen = Math.max(maxlen, left);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlen = Math.max(maxlen, left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxlen * 2;
    }
}