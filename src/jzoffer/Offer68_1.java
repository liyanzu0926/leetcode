package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/29 11:50
 */
public class Offer68_1 {
}

class Solution68_1_1 {
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

class Solution68_1_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (ancestor.val < p.val && ancestor.val < q.val) {
                ancestor = ancestor.right;
            } else if (ancestor.val > p.val && ancestor.val > q.val) {
                ancestor = ancestor.left;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
