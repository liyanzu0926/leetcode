package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 思想：排序+双指针
 * 改进版
 */

public class Lc15_2 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; //剪纸操作，如果三个数中最小的都大于0，三个数之和肯定也大于0
            if (i > 0 && nums[i] == nums[i - 1]) { //保证后移元素不能与之前相同
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    //相等之后，左指针要往右移一步，右指针要往左移一步
                    left++;
                    right--;
                    //因为左指针移动后不能与之前相同，所以要想和为0，右指针必须要往左移一步,且不能与之前相同
                    while (left < right && nums[left] == nums[left - 1]) left++; //去重
                    while (left < right && nums[right] == nums[right + 1]) right--; //去重
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
