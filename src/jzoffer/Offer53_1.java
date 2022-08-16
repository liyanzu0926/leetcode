package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/16 9:59
 */
public class Offer53_1 {
}

class Solution53_1_1 {
    public int search(int[] nums, int target) {
        int index = binarySearch(nums, 0, nums.length - 1, target);
        if (index >= nums.length || nums[index] != target) {
            return 0;
        }
        int i = index;
        while (i < nums.length && nums[i] == target) {
            i++;
        }
        return i - index;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

class Solution53_1_2 {
    public int search(int[] nums, int target) {
        int i = binarySearch1(nums, 0, nums.length - 1, target);
        if (i >= nums.length || nums[i] != target) {
            return 0;
        }
        int j = binarySearch2(nums, 0, nums.length - 1, target);
        return j - i;
    }

    // 返回第一个等于target的下标
    private int binarySearch1(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 返回第一个大于target的下标
    private int binarySearch2(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
