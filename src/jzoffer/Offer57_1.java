package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/17 11:14
 */
public class Offer57_1 {
}

class Solution57_1_1 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int curr = nums[i] + nums[j];
            if (curr > target) {
                j--;
            } else if (curr < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }
}
