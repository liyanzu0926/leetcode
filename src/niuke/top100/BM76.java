package niuke.top100;

import java.util.*;


public class BM76 {

    public boolean match(String str, String pattern) {
        // write code here
        int len1 = str.length();
        int len2 = pattern.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        // 下面是为了初始化x*x*x*x*这种情况
        for (int j = 2; j <= len2; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (pattern.charAt(j - 1) != '*') {
                    if (isMatch(str.charAt(i - 1), pattern.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else {

                    // 判断pattern '*'之前的字符是否和str当前字符匹配
                    if (isMatch(str.charAt(i - 1), pattern.charAt(j - 2))) {
                        //‘*’之前的字符取0次 || ‘*’之前的字符取多次
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    // 判断当前两个字符是否匹配
    private boolean isMatch(char ch1, char ch2) {
        if (ch1 == ch2 || ch2 == '.') {
            return true;
        }
        return false;
    }
}
