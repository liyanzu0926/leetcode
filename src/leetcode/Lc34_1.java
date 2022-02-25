package leetcode;

import java.util.Arrays;

public class Lc34_1 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        Solution34_1 solution34_1 = new Solution34_1();
        System.out.println(Arrays.toString(solution34_1.searchRange(nums, target)));
    }
}

class Solution34_1 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] index = new int[2];
        index[0] = index[1] = -1;
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                int i;
                for (i = mid; i >= 0; i--) {
                    if (nums[i] < target) {
                        break;
                    }
                }
                index[0] = i + 1;
                for (i = mid; i < len; i++) {
                    if (nums[i] > target) {
                        break;
                    }
                }
                index[1] = i - 1;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

}