package leetcode;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 */

public class Lc32_2 {


    public static void main(String[] args) {
        String s = "()()())()()()()";
        Solution2 solution = new Solution2();
        System.out.println(solution.longestValidParentheses(s));
    }

}

class Solution2 {
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
