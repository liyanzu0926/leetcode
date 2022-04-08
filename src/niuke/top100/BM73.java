package niuke.top100;

import java.util.*;


class BM73_1 {
    public int getLongestPalindrome(String A) {
        // write code here
        int maxLen = 1;
        for (int i = 0; i < A.length() - 1; i++) {
            int oddLen = centerExpand(A, i, i);
            int evenLen = centerExpand(A, i, i + 1);
            maxLen = Math.max(maxLen, Math.max(oddLen, evenLen));
        }
        return maxLen;
    }

    private int centerExpand(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

class BM73_2 {

    public int getLongestPalindrome(String A) {
        // write code here
        int len = A.length();
        if (len < 2) {
            return len;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxlen = 1;
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                // 两边相等且长度小于等于3，则为回文串
                if (A.charAt(left) == A.charAt(right) && (right - left < 3 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    maxlen = Math.max(maxlen, right - left + 1);
                }
            }
        }
        return maxlen;
    }
}
