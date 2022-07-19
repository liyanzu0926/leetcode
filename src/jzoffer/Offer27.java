package jzoffer;

import leetcode.TreeNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/19 10:54
 */
public class Offer27 {
}

class Solution27_1 {
    TreeNode temp = null;
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
