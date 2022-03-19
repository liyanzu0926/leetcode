package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc560 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;
        System.out.println(new Solution560_1().subarraySum(nums, k));
    }
}

/**
 * 枚举
 */
class Solution560_1 {
    public int subarraySum(int[] nums, int k) {
        int sum;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }
}

/**
 * 前缀和+哈希表
 * 前缀和的思想为：
 * pre[i]记录从0到i的和，则如果pre[i] - pre[j-1] = k
 * 那么从 j 到 i 之间元素和等于k，即nums[j] + nums[j+1] + ... + nums[i] = k
 * 则pre[j-1] = pre[i] - k
 * 用哈希表记录pre[i]出现的次数，则当我们计算pre[i] - k出现次数时，该值已经在hash表中了，该次数即为和为k的子数组的个数
 *
 */
class Solution560_2 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
