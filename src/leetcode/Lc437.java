package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc437 {
    public static void main(String[] args) {
        Integer[] root = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        int targetSum = 8;
        TreeNode treeNode = TreeUtils.createTreeBylevelOrder(root);
        System.out.println(new Solution437_2().pathSum(treeNode, targetSum));
    }
}

class Solution437_1 {
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (root.val == targetSum) {
            count++;
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }
}

class Solution437_2 {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, map, 0, targetSum);
        return count;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map, int currVal, int targetSum) {
        if (root == null){
            return;
        }
        currVal += root.val;
        count += map.getOrDefault(currVal - targetSum, 0);
        map.put(currVal, map.getOrDefault(currVal, 0) + 1);
        dfs(root.left, map, currVal, targetSum);
        dfs(root.right, map, currVal, targetSum);
        map.put(currVal, map.getOrDefault(currVal, 0) - 1);
    }
}
