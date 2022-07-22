package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/7/22 10:36
 */
public class Offer33 {
}

class Solution33_1 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) { // 由后续遍历的特性可知,j为根结点
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) p++; // 找到右子树在postorder中的第一个结点
        int m = p;
        while (postorder[p] > postorder[j]) p++; // 右子树所有结点都应大于根结点，所以循环结束后p应该等于j
        // 如上，p要等与j才满足后序遍历特性，且左右子树也都要成立
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
