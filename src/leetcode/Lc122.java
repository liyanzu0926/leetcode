package leetcode;

public class Lc122 {
}

/**
 * 动态规划
 */
class Solution122_1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 不持有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  // 持有股票
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}

/**
 * 动态规划优化
 */
class Solution122_2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int d1 = 0; // 不持有
        int d2 = -prices[0]; // 持有
        for (int i = 1; i < len; i++) {
            int newD1 = Math.max(d1, d2 + prices[i]);
            int newD2 = Math.max(d2, d2 - prices[i]);
            d1 = newD1;
            d2 = newD2;
        }
        return d1;
    }
}

/**
 * 贪心
 * 当天卖出，当天还可以买入
 * 只要明天比今天高，就可以盈利
 * 所有盈利和即为结果
 */
class Solution_3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 1; i < len; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]); // 大于0说明盈利
        }
        return res;
    }
}
