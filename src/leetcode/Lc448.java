package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc448 {
}

class Solution448_1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        boolean[] flag = new boolean[len];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            flag[nums[i] - 1] = true;
        }
        for (int i = 0; i < len; i++) {
            if (!flag[i]) {
                list.add(i + 1);
            }
        }
        return list;
    }

    class Solution448_2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int len = nums.length;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                nums[(nums[i] - 1) % len] += len;
            }
            for (int i = 0; i < len; i++) {
                if (nums[i] <= len) {
                    list.add(i + 1);
                }
            }
            return list;
        }
    }
}
