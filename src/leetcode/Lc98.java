package leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

public class Lc98 {
    public static void main(String[] args) {

    }
}

/**
 * 递归中序遍历
 */
class Solution98_1 {
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}

/**
 * 非递归中序遍历
 */
class Solution98_2 {

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode preNode = null;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (preNode !=null && preNode.val >= root.val) return false;
            preNode = root;
            root = root.right;
        }
        return true;
    }
}
