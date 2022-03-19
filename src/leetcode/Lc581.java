package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Lc581 {
}

/**
 * 将数组排序，然后和原数组比较
 */
class Solution581_1 {
    public int findUnsortedSubarray(int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);
        int start = 0;
        int end = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != newNums[i]){
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != newNums[i]){
                end = i;
                break;
            }
        }
        if (end == nums.length){
            return 0;
        }
        return end - start + 1;
    }
}

/**
 * 从前往后找到最后一个使元素不在正确位置上的元素下标，记为right
 * 从后往前找到最后一个使元素不在正确位置上的元素下标，记为left
 * 则最短无序连续子数组长度即为 right -left + 1
 */
class Solution581_2 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max){
                right = i;
            }else {
                max = nums[i];
            }
            if (nums[len - i - 1] > min){
                left = len - i - 1;
            }else {
                min = nums[len - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
