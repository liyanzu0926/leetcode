package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/16 10:32
 */
public class Offer53_2 {
}

class Solution53_2_1 {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        return xor;
    }
}

class Solution53_2_2 {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = (n - 1) * n / 2;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
        }
        return total - sum;
    }
}

class Solution53_2_3 {
    public int missingNumber(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
