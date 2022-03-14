package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class TreeUtils {
    // 前序遍历创建二叉树
    public static TreeNode createTree(Integer[] root, int index) {
        if (index >= root.length) {
            return null;
        }
        if (root[index] == null) return null;
        TreeNode treeNode = new TreeNode(root[index]);
        treeNode.left = createTree(root, 2 * index + 1);
        treeNode.right = createTree(root, 2 * index + 2);
        return treeNode;
    }

    // 层次遍历创建二叉树
    public static TreeNode createTreeBylevelOrder(Integer[] root) {
        if (root.length == 0 || root[0] == null) return null;
        TreeNode rootNode = new TreeNode(root[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        int index = 0;
        while (index < root.length) {
            TreeNode node = queue.poll();
            if (index + 1 < root.length && root[index + 1] != null){
                node.left = new TreeNode(root[index + 1]);
                queue.offer(node.left);
            }
            index++;
            if (index + 1 < root.length && root[index + 1] != null){
                node.right = new TreeNode(root[index + 1]);
                queue.offer(node.right);
            }
            index++;
        }
        return rootNode;
    }
}
