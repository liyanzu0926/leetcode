package leetcode;

public class Lc215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(new Solution215_3().findKthLargest(nums, k));
    }
}

/**
 * 快排思想（非递归）
 */
class Solution215_1 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int low = 0;
        int high = len - 1;
        int i = low;
        int j = high;
        int pivot;
        while (low < high) {
            pivot = nums[i];
            while (i < j) {
                while (i < j && nums[j] >= pivot) j--;
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] < pivot) i++;
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = pivot;
            if (i == target) {
                break;
            } else if (i < target) {
                low = i + 1;
                i = low;
                j = high;
            } else {
                high = i - 1;
                j = high;
                i = low;
            }
        }
        return nums[i];
    }
}

/**
 * 快排思想（递归）
 */
class Solution215_2 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        return quickSort(nums, 0, len - 1, target);
    }

    private int quickSort(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int i = low, j = high;
        int pivot = nums[low];
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < pivot) i++;
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        if (i == target) {
            return nums[i];
        } else if (i < target) {
            return quickSort(nums, i + 1, high, target);
        } else {
            return quickSort(nums, low, i - 1, target);
        }
    }
}

/**
 * 堆排序思想
 */
class Solution215_3 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        createHeapTree(nums);
        for (int i = len - 1; i >= len - k + 1; i--) {
            swap(nums, 0, i);
            sift(nums, 0, i - 1);
        }
        return nums[0];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void createHeapTree(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--){
            sift(nums, i, len - 1);
        }
    }

    private void sift(int[] nums, int low, int high) {
        int i = low;
        int j = 2 * i + 1;
        int temp = nums[i];
        while (j <= high){
            if (j < high && nums[j] < nums[j + 1]){
                j++;
            }
            if (temp < nums[j]){
                nums[i] = nums[j];
                i = j;
                j = 2 * i + 1;
            }else {
                break;
            }
        }
        nums[i] = temp;
    }

}
