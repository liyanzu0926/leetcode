package niuke.top100;

import leetcode.TreeNode;

public class BM30 {
    TreeNode preNode = null;
    TreeNode res = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inorder(pRootOfTree);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (preNode != null) {
            preNode.right = root;
            root.left = preNode;
        } else {
            res = root;
        }
        preNode = root;
        inorder(root.right);
    }
}
