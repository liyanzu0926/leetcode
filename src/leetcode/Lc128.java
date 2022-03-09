package leetcode;

import java.util.*;

public class Lc128 {
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(new Solution128_1().longestConsecutive(nums));
    }
}

class Solution128_1 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            if (set.contains(num - 1)){
                continue;
            }else {
                int key = num + 1;
                int count = 1;
                while (set.contains(key)){
                    count++;
                    key++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
