package jzoffer;

import leetcode.TreeNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/19 11:07
 */
public class Offer28 {
}

class Solution28_1 {
    public boolean isSymmetric(TreeNode root) {
        return preorder(root, root);
    }

    private boolean preorder(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null || r1.val != r2.val) {
            return false;
        }
        return preorder(r1.left, r2.right) && preorder(r1.right, r2.left);
    }
}
