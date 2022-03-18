package leetcode;

import java.util.Arrays;

public class Lc416 {
    public static void main(String[] args) {
        int[] w = {2, 3, 4, 7};
        int[] c = {1, 3, 5, 9};
        int n = 10;
        int m = 4;
        int[] dp = new int[n + 1];
        // 如果是求最大价值，则dp初始化位MIN_VALUE，反之则初始化位MAX_VALUE
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = n; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + c[i]);
            }
        }
        System.out.println(dp[n]);
    }
}

class Solution416_1 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}

class Solution416_2 {
    public boolean canPartition(int[] nums) {
        return false;
    }
}
