package niuke.top100;

import leetcode.TreeNode;

import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class BM27 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        boolean flag = false;
        int currLevelNodeNum = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!flag) {
                curr.add(node.val);
            } else {
                curr.add(0, node.val);
            }
            currLevelNodeNum--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (currLevelNodeNum == 0) {
                res.add(curr);
                curr = new ArrayList<>();
                currLevelNodeNum = queue.size();
                flag = !flag;
            }
        }
        return res;
    }

}
