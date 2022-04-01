package niuke.top100;

import leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
class BM31_1 {
    boolean isSymmetrical(TreeNode pRoot) {
        return check(pRoot, pRoot);
    }

    boolean check(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        return leftNode.val == rightNode.val && check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
    }
}

class BM31_2 {
    boolean isSymmetrical(TreeNode pRoot) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode p = pRoot;
        TreeNode q = pRoot;
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
