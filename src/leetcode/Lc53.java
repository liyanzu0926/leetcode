package leetcode;

public class Lc53 {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(new Solution53_2().maxSubArray(nums));
    }
}

class Solution53_1 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxans = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}

class Solution53_2 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < len; i++) {
            local = Math.max(local + nums[i], nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }
}