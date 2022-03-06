package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Lc104 {
}

/**
 * 递归
 */
class Solution104_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
}

/**
 * 层次遍历
 */
class Solution104_2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            depth++;
            for (int i = 0; i < currentLevelSize; i++) {
                root = queue.poll();
                if (root.left != null){
                    queue.offer(root.left);
                }
                if (root.right != null){
                    queue.offer(root.right);
                }
            }
        }
        return depth;
    }
}
