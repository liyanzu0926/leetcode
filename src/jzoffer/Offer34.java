package jzoffer;

import leetcode.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/3 11:12
 */
public class Offer34 {
}

class Solution34_1 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        preorder(root, target);
        return res;
    }

    private void preorder(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(cur));
        }
        preorder(root.left, target);
        preorder(root.right, target);
        cur.remove(cur.size() - 1);
    }
}

class Solution34_2 {
    List<List<Integer>> res = new ArrayList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return res;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        Deque<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int rootSum = sumQueue.poll() + node.val;
            if (node.left == null && node.right == null && rootSum == target) {
                getPath(node);
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(rootSum);
                map.put(node.left, node);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(rootSum);
                map.put(node.right, node);
            }
        }
        return res;
    }

    private void getPath(TreeNode node) {
        LinkedList<Integer> cur = new LinkedList<>();
        while (node != null) {
            // 头插法
            cur.addFirst(node.val);
            node = map.get(node);
        }
        res.add((List<Integer>) cur);
    }
}
