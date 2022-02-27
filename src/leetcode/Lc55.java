package leetcode;

public class Lc55 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new Solution55_1().canJump(nums));
    }
}

class Solution55_1 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxDistance = nums[0];
        for (int i = 0; i <= maxDistance; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
