package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/8 9:42
 */
public class Offer39 {
}

/**
 * @Description: 用map记录出现次数
 * @author: lyz
 * @date: 2022/8/8 9:42
 */
class Solution39_1 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxKey = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
                if (count > maxCount) {
                    maxCount = count;
                    maxKey = nums[i];
                }
            }
        }
        return maxKey;
    }
}

class Solution39_2 {
    public int majorityElement(int[] nums) {
        int k = 1;
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[flag]) {
                k++;
            } else {
                k--;
                if (k <= 0) {
                    k = 1;
                    flag = i;
                }
            }
        }
        return nums[flag];
    }
}

class Solution39_3 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
