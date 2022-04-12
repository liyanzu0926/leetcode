package niuke.top100;

import java.util.*;


class BM81_1 {

    public int maxProfit(int[] prices) {
        // write code here
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}

class BM81_2 {

    public int maxProfit (int[] prices) {
        // write code here
        int len = prices.length;
        int d1 = 0;
        int d2 = -prices[0];
        for(int i = 1; i < len; i++){
            int newD1 = Math.max(d1, d2 + prices[i]);
            int newD2 = Math.max(d2, d1 - prices[i]);
            d1 = newD1;
            d2 = newD2;
        }
        return d1;
    }
}
