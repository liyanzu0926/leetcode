package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/4 11:27
 */
public class Offer36 {
}

class Solution36_1 {
    TreeNode head = null;
    TreeNode pre = null;
    TreeNode cur = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        cur.right = head;
        head.left = cur;
        return head;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        cur = root;
        if (head == null) {
            head = root;
            pre = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        inorder(root.right);
    }
}
