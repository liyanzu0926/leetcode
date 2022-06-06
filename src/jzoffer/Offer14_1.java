package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/6/6 20:14
 */
public class Offer14_1 {
}

/**
 * @author: lww
 * @date: 2022/6/6 20:18
 * @Description:
 * dp[i]表示长度为 i 的绳子，剪成两段或两段以上后，各段绳子长度乘积的最大值
 * 则当 i >= 2 时，设第一段绳子长度为 j ，则剩下一部分绳子有两种可能：
 * 1. 剩下绳子不再继续剪，则此时乘积为 j * (i - j)
 * 2. 剩下绳子继续剪， 则此时乘积为 j * dp[i - j]
 * 则 dp[i] = max(j * (i - j) , j * dp[i - j])
 * j 的取值范围为 [1, i - 1]，所以要遍历所有的j，以找出最大的dp[i]
 */
class Solution14_1_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // for(int j = 1; j <= i / 2; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
