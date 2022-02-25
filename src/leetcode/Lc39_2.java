package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc39_2 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution39_2 solution39_2 = new Solution39_2();
        System.out.println(Arrays.toString(solution39_2.combinationSum(candidates, target).toArray()));
    }
}

class Solution39_2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, res, combination, target, 0);
        return res;
    }

    public void dfs(int[] candidates, List<List<Integer>> res, List<Integer> combination, int target, int begin) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            combination.add(candidates[i]);
            dfs(candidates, res, combination, target - candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}
