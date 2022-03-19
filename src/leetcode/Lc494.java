package leetcode;

import java.util.Arrays;

public class Lc494 {
}

/**
 * 深度遍历
 */
class Solution494_1 {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length){
            if (sum == target){
                count++;
            }
        }else {
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }
}

/**
 * 01背包
 */

/**
 * 01背包优化
 */
class Solution494_2 {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += nums[i];
        }
        if (sum - target < 0 || (sum - target) % 2 == 1){
            return 0;
        }
        int neg = (sum - target) / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++){
            for (int j = neg; j >=nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];
    }
}
