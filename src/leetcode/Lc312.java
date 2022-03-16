package leetcode;

public class Lc312 {
}

/**
 * 动态规划
 * 从上向下计算
 * dp[i][j]表示区间(i,j)上能获得的最大硬币数
 */
class Solution312_1 {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[len + 2];
        newNums[0] = 1;
        newNums[len + 1] = 1;
        for (int i = 1; i <= len; i++) {
            newNums[i] = nums[i - 1];
        }
        nums = newNums;
        int[][] dp = new int[len + 2][len + 2];
        for (int j = 2; j <= len + 1; j++) {
            for (int i = j - 2; i >= 0; i--) {
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j]);
                }
            }
        }
        return dp[0][len + 1];
    }
}

/**
 * 动态规划
 * 从下向上计算
 */
class Solution312_2 {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[len + 2];
        newNums[0] = 1;
        newNums[len + 1] = 1;
        for (int i = 1; i <= len; i++) {
            newNums[i] = nums[i - 1];
        }
        nums = newNums;
        int[][] dp = new int[len + 2][len + 2];
        for (int i = len - 1; i >= 0 ; i--) {
            for (int j = i + 2; j <= len + 1; j++) {
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j]);
                }
            }
        }
        return dp[0][len + 1];
    }
}