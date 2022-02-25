package leetcode;


/**
 * 32. 最长有效括号
 */

public class Lc32_3 {


    public static void main(String[] args) {
        String s = "()()())()()()()";
        Solution3 solution = new Solution3();
        System.out.println(solution.longestValidParentheses(s));
    }

}

class Solution3 {
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
