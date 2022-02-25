package leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 */

public class Lc32 {


    public static void main(String[] args) {
        String s = "()()())()()()()";
        Solution32_1 solution = new Solution32_1();
        System.out.println(solution.longestValidParentheses(s));
    }

}

class Solution32_1 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int maxans = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

class Solution32_2 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}

class Solution32_3 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxans = Math.max(maxans, left * 2);
            }else if (right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left == right){
                maxans = Math.max(maxans, left * 2);
            }else if (right < left){
                left = right = 0;
            }
        }
        return maxans;
    }
}
