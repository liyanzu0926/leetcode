package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc337 {
}

class Solution337_1 {
    Map<TreeNode, Integer> f = new HashMap<>();
    Map<TreeNode, Integer> g = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }
}

class Solution337_2 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int select = root.val + l[1] + r[1];
        int noSelect = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{select, noSelect};
    }
}
