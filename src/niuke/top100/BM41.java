package niuke.top100;

import leetcode.TreeNode;

import java.util.*;


public class BM41 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = buildTreeByPreorderAndInorder(xianxu, 0, xianxu.length - 1, zhongxu, 0, zhongxu.length - 1);
        return BFS(root);

    }

    private int[] BFS(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currLevelNodeNum = queue.size();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currLevelNodeNum--;
            if (currLevelNodeNum == 0) {
                list.add(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (currLevelNodeNum == 0) {
                currLevelNodeNum = queue.size();
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private TreeNode buildTreeByPreorderAndInorder(int[] pre, int l1, int r1, int[] vin, int l2, int r2) {
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
        node.left = buildTreeByPreorderAndInorder(pre, l1 + 1, l1 + i - l2, vin, l2, i - 1);
        node.right = buildTreeByPreorderAndInorder(pre, l1 + i - l2 + 1, r1, vin, i + 1, r2);
        return node;
    }
}
