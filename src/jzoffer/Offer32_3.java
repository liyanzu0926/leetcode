package jzoffer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author lyz
 * @Date 2022/7/21 11:30
 */
public class Offer32_3 {
}

class Solution32_3_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> cur = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevelNodeNum = 1;
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag) {
                cur.addFirst(node.val);
            } else {
                cur.addLast(node.val);
            }
            curLevelNodeNum--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (curLevelNodeNum == 0) {
                res.add((List<Integer>) cur);
                cur = new LinkedList<>();
                flag = !flag;
                curLevelNodeNum = queue.size();
            }
        }
        return res;
    }
}
