package leetcode;

public class Lc309 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new Solution309_1().maxProfit(prices));
    }
}

/**
 * dp[i]表示当天结束后累计最大收益
 * <p>
 * dp[i][0] 当天买入
 * dp[i][1] 当天卖出，下一天处于冷冻期
 * dp[i][2] 冷冻期
 * dp[i][3] 不持有股票，且非冷冻期
 * <p>
 * dp[i][0]可以是dp[i-1][0]转移而来，即今天没进行任何操作，直接继承昨天的状态。也可以由dp[i-1][2]或dp[i-1][3] - prices[i]转移而来，即今天买入一只股票。
 * dp[i][1]可由dp[i-1][0] + prices[i]转移而来，即当天卖出一只股票。
 * dp[i][2] dp[i-1][1]
 * dp[i][3]可由dp[i-1][3] 或dp[i-1][2]
 */
class Solution309_1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (prices == null || len == 0) return 0;
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][3] - prices[i]), dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = dp[i - 1][1];
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][3]);
//        return Math.max(Math.max(Math.max(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]), dp[len - 1][3]);
    }
}

class Solution309_2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (prices == null || len == 0){
            return 0;
        }
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(Math.max(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
    }
}

/**
 * 优化掉dp数组
 */
class Solution309_3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (prices == null || len == 0){
            return 0;
        }
        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 1; i < len; i++) {
            int newdp0 = Math.max(dp0, dp2 - prices[i]);
            int newdp1 = dp0 + prices[i];
            int newdp2 = Math.max(dp1, dp2);
            dp0 = newdp0;
            dp1 = newdp1;
            dp2 = newdp2;
        }
        return Math.max(Math.max(dp0, dp1), dp2);
    }
}
