package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc128 {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(new Solution128_1().longestConsecutive(nums));
    }
}

class Solution128_1 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] + 1;
            while (map.containsKey(key)) {
                int newValue = map.get(key) + 1;
                res = Math.max(res, newValue);
                map.put(key, newValue);
                key++;
            }
        }
        return res;
    }
}
