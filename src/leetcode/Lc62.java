package leetcode;

public class Lc62 {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(new Solution62_1().uniquePaths(m, n));
    }
}

class Solution62_1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到达当前格路径条数等于它上一格+左一格的路径数
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
