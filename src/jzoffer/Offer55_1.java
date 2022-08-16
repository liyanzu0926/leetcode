package jzoffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/16 11:12
 */
public class Offer55_1 {
}

class Solution55_1_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class Solution55_1_2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currLevelNodeNum = 1;
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currLevelNodeNum--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (currLevelNodeNum == 0) {
                depth++;
                currLevelNodeNum = queue.size();
            }
        }
        return depth;
    }
}
