package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/16 11:08
 */
public class Offer54 {
}

class Solution54_1 {
    int res = 0;
    int count = 0;

    public int kthLargest(TreeNode root, int k) {
        reverseInorder(root, k);
        return res;
    }

    private void reverseInorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        reverseInorder(root.right, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        reverseInorder(root.left, k);
    }
}
