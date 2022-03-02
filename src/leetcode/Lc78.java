package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution78_3().subsets(nums).toString());
    }
}

class Solution78_1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> initList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(initList);
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = res.get(j);
                ArrayList<Integer> subList = new ArrayList<>(list);
                subList.add(nums[i]);
                res.add(subList);
            }
        }
        return res;
    }
}

/**
 * 回溯
 */
class Solution78_2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            recall(nums, len, 0, i, new ArrayList<Integer>());
        }
        return res;
    }

    private void recall(int[] nums, int len, int begin, int depth, List<Integer> cur) {
        if (depth == 0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = begin; i < len; i++) {
            cur.add(nums[i]);
            recall(nums, len, i + 1, depth - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}

class Solution78_3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = (int) Math.pow(2, len); i < Math.pow(2, len + 1); i++) {
            String s = Integer.toBinaryString(i).substring(1);
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (s.charAt(j) == '1'){
                    subList.add(nums[j]);
                }
            }
            res.add(subList);
        }
        return res;
    }
}
