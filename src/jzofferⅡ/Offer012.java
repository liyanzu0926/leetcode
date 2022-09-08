package jzofferⅡ;

import java.util.Arrays;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/8 11:08
 */
public class Offer012 {
}

class Solution012_1 {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
