package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Lc114 {
    public static void main(String[] args) {
        Integer[] root = {1, 2, 5, 3, 4, null, 6};
        TreeNode tree = TreeUtils.createTree(root, 0);
        new Solution114_1().flatten(tree);
    }
}

/**
 * 先用前序遍历一遍，把结点值存起来，再按顺序重新创建树
 */
class Solution114_1 {
    List<Integer> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode p = root;
        preorder(root);
        p = root;
        p.left = null;
        for (int i = 1; i < list.size(); i++) {
            p.right = new TreeNode(list.get(i));
            p.left = null;
            p = p.right;
        }
    }

    private void preorder(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}

/**
 * 迭代，并在迭代过程完成二叉树的重构
 */
class Solution114_2 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode preNode = null;
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.poll();
            if (preNode != null) {
                preNode.right = currNode;
                preNode.left = null;
            }
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.right != null) {
                stack.push(currNode.left);
            }
            preNode = currNode;
        }
    }
}

class Solution114_3 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode currNode = root;
        TreeNode preNode = null;
        while (currNode != null){
            if (currNode.left != null){
                preNode = currNode.left;
                while (preNode.right != null){
                    preNode = preNode.right;
                }
                preNode.right = currNode.right;
                currNode.right = currNode.left;
                currNode.left = null;
            }
            currNode = currNode.right;
        }
    }
}
