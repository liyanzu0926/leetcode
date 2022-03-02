package leetcode;

import java.util.Arrays;

public class Lc75 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Solution75_3().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

/**
 * 一个头指针，一个尾指针，一个游走指针，
 * 当游走指针为红色，则与头指针交换，
 * 当游走指针为白色，则前移
 * 当游走指针为蓝色，则与尾指针交换
 */
class Solution75_1 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int left = 0;
        int mid = 0;
        int right = len - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                mid++;
                left++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int left, int mid) {
        int temp = nums[left];
        nums[left] = nums[mid];
        nums[mid] = temp;
    }
}

/**
 * 先将红色移到前面，再将白色移到红色前面
 */
class Solution75_2 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int ptr = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0){
                swap(nums, i, ptr);
                ptr++;
            }
        }
        for (int i = ptr; i < len; i++) {
            if (nums[i] == 1){
                swap(nums, i, ptr);
                ptr++;
            }
        }
    }

    private void swap(int[] nums, int left, int mid) {
        int temp = nums[left];
        nums[left] = nums[mid];
        nums[mid] = temp;
    }
}

class Solution75_3 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                break;
            }
        }
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] > pivot) right--;
            if (left < right){
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] <= pivot) left++;
            if (left < right){
                nums[right--] = nums[left];
            }
        }
        nums[left] = pivot;
    }
}


