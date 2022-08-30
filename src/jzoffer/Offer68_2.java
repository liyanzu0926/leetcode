package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/29 15:53
 */
public class Offer68_2 {
}

class Solution68_2_1 {
    TreeNode ancestor = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (left && right || (root == p || root == q) && (left || right)) {
            ancestor = root;
        }
        return left || right || root == p || root == q;
    }
}
