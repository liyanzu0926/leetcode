package test;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(nums, 6));

    }

    private static int binarySearch(int[] sums, int target) {
        int left = 0;
        int right = sums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 2);
            if (sums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
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
            int mid = left + (right - left >> 2);
            if (sums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}


