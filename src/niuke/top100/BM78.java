package niuke.top100;

import java.util.*;


class BM78_1 {

    public int rob(int[] nums) {
        // write code here
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}

class BM78_2 {

    public int rob(int[] nums) {
        // write code here
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int two = nums[0];
        int one = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int curr = Math.max(one, two + nums[i]);
            two = one;
            one = curr;
        }
        return one;
    }
}