package leetcode;

public class Lc124 {
    public static void main(String[] args) {
        Integer[] root = {-10, 9, 20, null, null, 15, 7};
        TreeNode tree = TreeUtils.createTree(root, 0);
        Solution124_1 solution1 = new Solution124_1();
        System.out.println(solution1.maxPathSum(tree));
    }
}

/**
 *     a
 *    / \
 *   b   c
 * 1.b + a + c。
 * 2.b + a + a 的父结点。
 * 3.c + a + a 的父结点。
 * 其中情况 1，表示如果不联络父结点的情况，或本身是根结点的情况。
 * 这种情况是没法递归的，但是结果有可能是全局最大路径和。
 * 情况 2 和 3，递归时计算 a+b 和 a+c，选择一个更优的方案返回，也就是上面说的递归后的最优解啦。
 *
 * 另外结点有可能是负值，最大和肯定就要想办法舍弃负值（max(0, x)）（max(0,x)）。
 * 但是上面 3 种情况，无论哪种，a 作为联络点，都不能够舍弃。
 *
 *代码中使用 global 来记录全局最大路径和。
 * local_1 是情况 1。
 * local_2_3 是情况 2 和 3。
 */
class Solution124_1 {
    int global = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return global;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 舍弃负值
        int local_1 = root.val + Math.max(left, 0) + Math.max(right, 0);
        int local_2_3 = root.val + Math.max(Math.max(left, right), 0);
        global = Math.max(global, Math.max(local_1, local_2_3));
        return local_2_3;
    }
}
