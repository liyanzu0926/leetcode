package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Lc617 {
}

/**
 * dfs
 */
class Solution617_1 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null){
                return root2;
            }
            if (root2 == null){
                return root1;
            }
            TreeNode merge = new TreeNode(root1.val + root2.val);
            merge.left = mergeTrees(root1.left, root2.left);
            merge.right = mergeTrees(root1.right, root2.right);
            return merge;
    }
}

/**
 * bfs
 */
class Solution617_2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode merge = new TreeNode(root1.val + root2.val);
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        Deque<TreeNode> queue3 = new LinkedList<>();
        queue1.offer(root1);
        queue2.offer(root2);
        queue3.offer(merge);
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            TreeNode node3 = queue3.poll();
            if (node1.left != null && node2.left != null){
                node3.left = new TreeNode(node1.left.val + node2.left.val);
                queue1.offer(node1.left);
                queue2.offer(node2.left);
                queue3.offer(node3.left);
                // 下面两种情况无需入队，不需要遍历了
            }else if (node1.left == null && node2.left != null){
                node3.left = node2.left;
            }else if (node1.left != null && node2.left == null){
                node3.left = node1.left;
            }
            if (node1.right != null && node2.right != null){
                node3.right = new TreeNode(node1.right.val + node2.right.val);
                queue1.offer(node1.right);
                queue2.offer(node2.right);
                queue3.offer(node3.right);
                // 下面两种情况无需入队，不需要遍历了
            }else if (node1.right == null && node2.right != null){
                node3.right = node2.right;
            }else if (node1.right != null && node2.right == null){
                node3.right = node1.right;
            }
        }
        return merge;
    }
}
