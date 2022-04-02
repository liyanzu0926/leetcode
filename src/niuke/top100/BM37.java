package niuke.top100;

import leetcode.TreeNode;

public class BM37 {
    /**
     * 如果root.val > p && root.val > q，说明p和q在root的左子树中，
     * 如果root.val < p && root.val < q，说明p和q在root的右子树中,
     * 如果当前结点不满足上述两个条件，说明该点为叉点，即为p和q的最近公共祖先，
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root.val > p && root.val > q) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p && root.val < q) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root.val;
        }
    }
}
