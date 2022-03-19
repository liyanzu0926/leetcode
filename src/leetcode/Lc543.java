package leetcode;

public class Lc543 {
    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, 4, 5};
        TreeNode tree = TreeUtils.createTreeBylevelOrder(root);
        System.out.println(new Solution543_1().diameterOfBinaryTree(tree));
    }
}

class Solution543_1 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
