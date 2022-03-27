package niuke.alibaba;

import java.util.*;

/**
 * 小强的神奇矩阵
 * https://www.nowcoder.com/questionTerminal/a132e8338b9e4545a154b1407cd41fd2
 */
public class _3xn {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[][] a = new int[3][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = cin.nextInt();
            }
        }
        long[][] dp = new long[3][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                long d0 = Math.abs(a[j][i] - a[0][i - 1]) + dp[0][i - 1];
                long d1 = Math.abs(a[j][i] - a[1][i - 1]) + dp[1][i - 1];
                long d2 = Math.abs(a[j][i] - a[2][i - 1]) + dp[2][i - 1];
                dp[j][i] = Math.min(Math.min(d0, d1), d2);
            }
        }
        System.out.println(Math.min(Math.min(dp[0][n - 1], dp[1][n - 1]), dp[2][n - 1]));
    }
}
