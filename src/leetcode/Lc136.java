package leetcode;

public class Lc136 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new Solution136_1().singleNumber(nums));
    }
}

/**
 *
 */
class Solution136_1 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
