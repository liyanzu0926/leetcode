package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/9 10:07
 */
public class Offer42 {
}

class Solution42_1 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i], nums[i] + pre);
            max = Math.max(max, pre);
        }
        return max;
    }
}
