package leetcode;

/**
 * 力扣第5题
 * 最长回文子串
 * 思想：中心扩展法
 */
public class Lc5_1 {
    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        int start = 0;
        int end = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int oddLen = expendCenter(s, i, i);  //回文串长是奇数
            int evenLen = expendCenter(s, i, i + 1);  //回文串长是偶数
            int len = Math.max(oddLen, evenLen);
            if (len > (end - start) + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        //end + 1是因为substring是左闭右开的
        return s.substring(start, end + 1);
    }

    private static int expendCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // len = right - 1 - (left + 1) + 1
        // len = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
