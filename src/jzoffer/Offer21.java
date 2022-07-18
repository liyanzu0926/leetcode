package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/18 12:19
 */
public class Offer21 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution21_1().exchange(nums));
    }
}

class Solution21_1 {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) i++;
            while (i < j && nums[j] % 2 == 0) j--;
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        return nums;
    }
}
