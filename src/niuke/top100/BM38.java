package niuke.top100;

import leetcode.TreeNode;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

class BM38_1 {
    private TreeNode ancestor = null;

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        dfs(root, o1, o2);
        return ancestor.val;
    }

    private boolean dfs(TreeNode root, int o1, int o2) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, o1, o2);
        boolean right = dfs(root.right, o1, o2);
        if (left && right || (root.val == o1 || root.val == o2) && (left || right)) {
            ancestor = root;
        }
        return left || right || (root.val == o1 || root.val == o2);
    }
}
