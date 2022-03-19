package leetcode;

public class Lc538 {
}

class Solution538_1 {
    TreeNode preNode = new TreeNode(0);
    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
        convertBST(root.right);
        root.val += preNode.val;
        preNode = root;
        convertBST(root.left);
        return root;
    }
}
