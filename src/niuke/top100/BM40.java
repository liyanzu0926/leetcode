package niuke.top100;

import leetcode.TreeNode;

public class BM40 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int l1, int r1, int[] vin, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        int i;
        for (i = l2; i <= r2; i++) {
            if (vin[i] == pre[l1]) {
                break;
            }
        }
        TreeNode node = new TreeNode(pre[l1]);
        node.left = reConstructBinaryTree(pre, l1 + 1, l1 + i - l2, vin, l2, i - 1);
        node.right = reConstructBinaryTree(pre, l1 + i - l2 + 1, r1, vin, i + 1, r2);
        return node;
    }
}
