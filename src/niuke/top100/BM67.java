package niuke.top100;

import java.util.*;


public class BM67 {

    public int uniquePaths(int m, int n) {
        // write code here
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

/**
 * O(1)空间复杂度的方法：
 * https://blog.nowcoder.net/n/0f96677ea2eb4fc2924688fcd306f890?f=comment
 */


