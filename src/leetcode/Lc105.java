package leetcode;

public class Lc105 {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 3, 1};
        TreeNode treeNode = new Solution105_1().buildTree(preorder, inorder);
    }
}

/**
 * 递归
 */
class Solution105_1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTreeByPreorderAndInorder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode createTreeByPreorderAndInorder(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) return null;
        TreeNode p = new TreeNode(preorder[l1]);
        int i;
        for (i = l2; i <= r2; i++) {
            if (preorder[l1] == inorder[i]) {
                break;
            }
        }
        // 在中序序列中找到l1结点的位置i，那i左边的结点即为l1左子树上的结点，i右边的结点即为l1右子树的结点
        // 这里l1 + i - l2是什么意思？
        // 答：在中序序列中，i号元素左边的的这些元素即为实际二叉树l1结点左子树上的结点，
        // 那i左边还有多少结点？ 还有 i - l2 个结点。这i - l2 个结点就是前序遍历前面几个结点。
        // 则l1左子树上的结点下标为(l1+1, l1+i-l2)
        p.left = createTreeByPreorderAndInorder(preorder, l1 + 1, l1 + i - l2, inorder, l2, i - 1);
        p.right = createTreeByPreorderAndInorder(preorder, l1 + i - l2 + 1, r1, inorder, i + 1, r2);
        return p;
    }
}
