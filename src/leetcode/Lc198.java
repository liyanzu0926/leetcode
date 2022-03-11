package leetcode;

public class Lc198 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution198_1().rob(nums));
    }
}

class Solution198_1 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int max = Math.max(nums[0], nums[1]);
        if (len == 2) return max;
        max = Math.max(nums[0] + nums[2], nums[1]);
        if (len == 3) return max;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < len; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

/**
 * 偷或不偷，dp数组总是记录当前状态下偷得的最高总额
 */
class Solution198_2 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}

/**
 * 优化掉dp数组
 */
class Solution198_3 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int twoStep = nums[0];
        int oneStep = Math.max(nums[0], nums[1]);
        int max = oneStep;
        for (int i = 2; i < len; i++) {
            max = Math.max(twoStep + nums[i], oneStep);
            twoStep = oneStep;
            oneStep = max;
        }
        return max;
    }
}
