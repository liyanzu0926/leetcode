package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/22 10:52
 */
public class Offer60 {
}

class Solution60_1 {
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) break;
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double total = Math.pow(6, n);
        double[] res = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[n][i] / total;
        }
        return res;
    }
}

class Solution60_2 {
    public double[] dicesProbability(int n) {
        int[] dp = new int[6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * n; j >= i; j--) {
                dp[j] = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j - k < i - 1) {
                        break;
                    }
                    dp[j] += dp[j - k];
                }
            }
        }
        double total = Math.pow(6, n);
        double[] res = new double[6 * n - n + 1];
        for (int i = n; i <= 6 * n; i++) {
            res[i - n] = dp[i] / total;
        }
        return res;
    }
}
