package leetcode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 思路：想要找到下一个字典序，需要从后面找到一个较大数，从前面找到一个较小数，然后交换，这样才能保证
 * 交换后的序列比之前的序列大。同时较大数要尽量靠后，且较小数和较大数相差要尽可能小。
 * 可以从后往前找到第一个逆序的地方，比如nums[i] < nums[j]  (i < j)，那么j之后的序列一定是降序的，
 * 如果不是,i和j就不会是第一个逆序点。此时可以将(j,end)按升序排列（可以不用sort，因为序列为降序，
 * 只需逆置序列即可得到升序序列），然后从j开始找到第一个大于nums[i]的数，
 * 这个数就是大于nums[i]且尽可能小的数，让它和nums[i]交换，此时序列即为下一个字典序列
 * <p>
 * 总之要满足：
 * 1.一个较大数和一个较小数
 * 2.较大数要尽可能靠后
 * 3.较大数和较小数相差尽可能小
 */

public class Lc31_1 {

    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) { //找到第一个逆序的地方，此时nuns(i,end)一定是降序的（因为如果不是降序，
                //那么它一定会是第一个逆序的地方
                reverse(nums, i, nums.length - 1);
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
