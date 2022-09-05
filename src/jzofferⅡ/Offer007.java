package jzofferⅡ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/5 10:53
 */
public class Offer007 {
}

class Solution007_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 先排序
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // 注意这里的j > i + 1不能忽略，相当于上面的i > 0
                    continue;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j >= k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    res.add(curr);
                }
            }
        }
        return res;
    }
}

class Solution007_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curr = nums[i] + nums[left] + nums[right];
                if (curr < 0) {
                    left++;
                } else if (curr > 0) {
                    right--;
                } else {
                    // 剪枝
                    if (nums[left] != nums[left - 1] || left - 1 == i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                    }
                    left++;
                }
            }
        }
        return res;
    }
}
