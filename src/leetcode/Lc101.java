package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Lc101 {

}

/**
 * 递归
 */
class Solution101_1 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return q.val == p.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

/**
 * 层次遍历
 */
class Solution101_2 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        TreeNode q = root;
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) continue;
            if (p == null || q == null || (q.val != p.val)) return false;
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}

/**
 * 层次遍历优化
 */
class Solution101_3 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left ==null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        TreeNode p = root.left;
        TreeNode q = root.right;
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) continue;
            if (p == null || q == null || (q.val != p.val)) return false;
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}