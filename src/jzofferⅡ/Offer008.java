package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/6 10:10
 */
public class Offer008 {
}

class Solution008_1 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

class Solution008_2 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= len; i++) {
            int sum = target + sums[i - 1];
            int index = binarySearch(sums, sum);
            if (index <= len) {
                res = Math.min(res, index - i + 1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int binarySearch(int[] sums, int target) {
        int left = 0;
        int right = sums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (sums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
