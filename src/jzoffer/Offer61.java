package jzoffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/23 10:12
 */
public class Offer61 {
}

class Solution61_1 {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min < 5;
    }
}

class Solution61_2 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int kingNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                kingNum++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[kingNum] < 5;
    }
}
