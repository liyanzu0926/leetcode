package leetcode;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int h = 1; h <= m; h++) {
                /*if(i > Math.pow(2, k) - 1){
                    break;
                }*/
                for (int j = 1; j <= i; j++) {
                    dp[h][i] = (dp[h][i] + dp[h - 1][j - 1] * dp[h - 1][i - j] % mod) % mod;
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
