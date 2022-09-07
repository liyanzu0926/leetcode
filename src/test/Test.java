package test;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(nums, 3));

    }

    private static int binarySearch(int[] sums, int target) {
        int left = 0;
        int right = sums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (sums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}



