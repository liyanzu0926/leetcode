package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/7 10:38
 */
public class Offer009 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(new Solution009_1().numSubarrayProductLessThanK(nums, k));
    }
}

class Solution009_1 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        double[] muls = new double[len + 1];
        for (int i = 1; i <= len; i++) {
            muls[i] = muls[i - 1] + Math.log(nums[i - 1]);
        }
        int res = 0;
        for (int i = 1; i <= len; i++) {
            double mul = muls[i] - Math.log(k) + 1e-10;
            int index = binarySearch(muls, 0, i - 1, mul);
            res += i - index;
        }
        return res;
    }

    // 返回第一个大于target的下标
    private int binarySearch(double[] muls, int left, int right, double target) {
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (muls[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

class Solution009_2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int product = 1;
        int res = 0;
        while (right < nums.length) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
