package leetcode;

import java.util.Arrays;

public class Lc34_2 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        Solution34_2 solution34_2 = new Solution34_2();
//        System.out.println(solution34_2.binarySearch(nums, 0, nums.length - 1, target));
        System.out.println(Arrays.toString(solution34_2.searchRange(nums, target)));
    }
}

class Solution34_2 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int a = binarySearch(nums, 0, len - 1, target);
        int b = binarySearch(nums, 0, len - 1, target + 1);
        if (a == len || nums[a] != target){
            return new int[]{-1, -1};
        }
        return new int[]{a, b - 1};

    }

    //找到第一个大于等于target的下标
    public int binarySearch(int[] nums, int left, int right, int target){
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] >= target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}