package leetcode;

public class Lc121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution121_2().maxProfit(prices));
    }
}

/**
 * 暴力
 */
class Solution121_1 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    res = Math.max(res, prices[j] - prices[i]);
                }
            }
        }
        return res;
    }
}

/**
 *
 */
class Solution121_2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int preMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > preMin) {
                res = Math.max(res, prices[i] - preMin);
            }
            preMin = Math.min(preMin, prices[i]);
        }
        return res;
    }
}

