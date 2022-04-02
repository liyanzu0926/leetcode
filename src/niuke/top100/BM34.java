package niuke.top100;

import leetcode.TreeNode;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class BM34 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val > root.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
