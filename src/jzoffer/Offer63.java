package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/25 9:56
 */
public class Offer63 {
}

class Solution63_1 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy = prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return sell;
    }
}

/**
 * @Description: 剪枝
 * @author: lyz
 * @date: 2022/8/25 10:00
 */
class Solution63_2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int buy = prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buy > sell) {
                sell = prices[i] - buy;
            } else {
                buy = Math.min(buy, prices[i]);
            }
        }
        return sell;
    }
}

class Solution63_3 {
    // 快慢指针
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int left = 0;
        int right = 1;
        int max = 0;
        while (right < len) {
            if (prices[left] < prices[right]) {
                max = Math.max(max, prices[right] - prices[left]);
            } else {
                // 找到了一个新谷点
                // 这里（left，right）区间内的值都是大于prices[left]的，所以直接跳到right
                // 因为prices[right] < prices[left]
                left = right;
            }
            right++;
        }
        return max;
    }
}
