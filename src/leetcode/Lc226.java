package leetcode;

public class Lc226 {
}

/**
 *
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        postOrder(root);
        return root;
    }

    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
    }
}
