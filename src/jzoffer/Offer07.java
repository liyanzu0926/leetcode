package jzoffer;

import leetcode.TreeNode;

/**
 * @Description
 * @Author lww
 * @Date 2022/6/1 11:54
 */
public class Offer07 {
}

class Solution07_1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeByPreorderAndInorder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeByPreorderAndInorder(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        int i = 0;
        for (i = l2; i <= r2; i++) {
            if (inorder[i] == preorder[l1]) {
                break;
            }
        }
        TreeNode node = new TreeNode(preorder[l1]);
        node.left = buildTreeByPreorderAndInorder(preorder, l1 + 1, l1 + i - l2, inorder, l2, i - 1);
        node.right = buildTreeByPreorderAndInorder(preorder, l1 + i - l2 + 1, r1, inorder, i + 1, r2);
        return node;
    }
}
