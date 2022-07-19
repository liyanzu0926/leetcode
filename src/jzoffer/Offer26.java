package jzoffer;

import leetcode.TreeNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/19 10:39
 */
public class Offer26 {
}

class Solution26_1 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 对应三种情况：
        // 以A为根结点的树包含B || A的左子树包含B || A的右子树包含B
        return preorder(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断B是否是以A为根结点的子结构（A树和B树同根）
    private boolean preorder(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return preorder(A.left, B.left) && preorder(A.right, B.right);
    }
}
