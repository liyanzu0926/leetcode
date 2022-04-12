package niuke.top100;

import java.util.*;


public class BM79 {

    public int rob(int[] nums) {
        // write code here
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, len - 1), helper(nums, 1, len));
    }

    private int helper(int[] nums, int start, int end) {
        int one = nums[start];
        int two = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int curr = Math.max(one + nums[i], two);
            one = two;
            two = curr;
        }
        return two;
    }
}
