package leetcode;


/**
 * 32. 最长有效括号
 */

public class Lc32_1 {


    public static void main(String[] args) {
        String s = "()()())()()()()";
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(s));
    }

}

class Solution {
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
