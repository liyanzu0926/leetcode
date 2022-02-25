package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc39_1 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution39_1 solution39_1 = new Solution39_1();
        System.out.println(Arrays.toString(solution39_1.combinationSum(candidates, target).toArray()));
    }
}

class Solution39_1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, res, combination, target, 0);
        return res;
    }

    public void dfs(int[] candidates, List<List<Integer>> res, List<Integer> combination, int target, int index) {
        if (index == candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        dfs(candidates, res, combination, target, index + 1);
        if (target - candidates[index] >= 0) {
            combination.add(candidates[index]);
            dfs(candidates, res, combination, target - candidates[index], index);
            combination.remove(combination.size() - 1);
        }
    }
}
