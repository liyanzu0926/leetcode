package leetcode;

public class Lc236 {
}

class Solution236_1 {
    TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (left && right || (root == p || root == q) && (left || right)){
            ancestor = root;
        }
        return left || right || root == p || root == q;
    }
}
