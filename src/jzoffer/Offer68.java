package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/29 11:50
 */
public class Offer68 {
}

class Solution68_1 {
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
        // p和q在当前结点左右子树上 || p或q是当前结点 && 另一结点在它的子树上
        if (left && right || (root == p || root == q) && (left || right)) {
            ancestor = root;
        }
        return left || right || root == p || root == q;
    }
}
