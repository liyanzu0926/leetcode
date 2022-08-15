package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/15 10:34
 */
public class Offer51 {
}

class Solution51_1 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] temp = new int[len];
        return mergesort(nums, 0, len - 1, temp);
    }

    private int mergesort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int leftInversionNum = mergesort(nums, left, mid, temp);
        int rightInversionNum = mergesort(nums, mid + 1, right, temp);
        int mergeInversionNum = merge(nums, left, mid, right, temp);
        return leftInversionNum + rightInversionNum + mergeInversionNum;
    }

    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }
        index = 0;
        while (left <= right) {
            nums[left++] = temp[index++];
        }
        return count;
    }
}

class Solution51_2 {
    int count = 0;

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] temp = new int[len];
        mergesort(nums, 0, len - 1, temp);
        return count;
    }

    private void mergesort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergesort(nums, left, mid, temp);
        mergesort(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) return; // 剪枝，如果已经有序
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }
        index = 0;
        while (left <= right) {
            nums[left++] = temp[index++];
        }
    }
}
