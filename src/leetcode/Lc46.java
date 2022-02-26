package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution46_1 solution46 = new Solution46_1();
        System.out.println(Arrays.toString(solution46.permute(nums).toArray()));
    }
}

class Solution46_1 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        // flag用于标记该元素是否已被并入
        boolean[] flag = new boolean[len];
        dfs(nums, len, 0, res, combination, flag);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<List<Integer>> res, List<Integer> combination, boolean[] flag) {
        if (depth >= len) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (flag[i]) continue;
            combination.add(nums[i]);
            flag[i] = true;
            dfs(nums, len, depth + 1, res, combination, flag);
            combination.remove(combination.size() - 1);
            flag[i] = false;
        }
    }
}

