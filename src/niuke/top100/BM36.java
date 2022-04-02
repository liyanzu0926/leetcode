package niuke.top100;

import leetcode.TreeNode;

public class BM36 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = IsBalanced_Solution(root.left);
        boolean right = IsBalanced_Solution(root.right);
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && left && right;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
