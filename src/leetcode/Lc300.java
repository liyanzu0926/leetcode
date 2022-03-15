package leetcode;

public class Lc300 {
}

class Solution300_1 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) return 1;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

class Solution300_2 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        int size = 1;
        dp[size] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[size]) {
                dp[++size] = nums[i];
            } else {
                int left = 1;
                int right = size;
                while (left <= right){
                    int mid = (left + right) >> 1;
                    if (dp[mid] < nums[i]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
                dp[left] = nums[i];
            }
        }
        return size;
    }
}
