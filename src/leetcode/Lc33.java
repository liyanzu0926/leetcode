package leetcode;

public class Lc33 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        Solution33_1 solution33 = new Solution33_1();
        System.out.println(solution33.search(nums, target));
    }
}

class Solution33_1 {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                break;
            }
        }
        if (binarySearch(nums, 0, i, target) != -1) {
            return binarySearch(nums, 0, i, target);
        } else {
            return binarySearch(nums, i + 1, nums.length - 1, target);
        }
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return -1;
    }
}

class Solution33_2 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

