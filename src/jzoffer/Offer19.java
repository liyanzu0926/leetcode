package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/18 10:04
 */
public class Offer19 {
}

class Solution19_1 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // s和p为空时匹配
        for (int i = 0; i <= m; i++) { // i和j表示长度
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (match(s, p, i, j - 1)) { // 这里传进去的i和j也是长度
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2]; // 匹配多次 || 匹配0次
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
