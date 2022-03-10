package leetcode;

public class Lc152 {
    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        System.out.println(new Solution152_1().maxProduct(nums));
    }
}

class Solution152_1 {
    public int maxProduct(int[] nums) {
        int localMax = nums[0];
        int localMin = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(nums[i], Math.max(localMax * nums[i], localMin * nums[i]));
            int min = Math.min(nums[i], Math.min(localMax * nums[i], localMin * nums[i]));
            localMax = max;
            localMin = min;
            global = Math.max(global, localMax);
        }
        return global;
    }
}
