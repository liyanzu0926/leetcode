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

class BM35_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree(TreeNode root) {
        // write code here
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                while (!queue.isEmpty()) {
                    if (queue.poll() != null) {
                        return false;
                    }
                }
                break;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return true;
    }
}


class BM35_2 {

    int count = 0;
    int maxIndex = -1;

    public boolean isCompleteTree(TreeNode root) {
        preorder(root, 1);
        return maxIndex == count;
    }

    private void preorder(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        count++;
        maxIndex = Math.max(maxIndex, index);
        preorder(root.left, index * 2);
        preorder(root.right, index * 2 + 1);
    }
}
