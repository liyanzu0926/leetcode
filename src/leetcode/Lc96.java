package leetcode;

public class Lc96 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution96_1().numTrees(n));
    }
}

/**
 * 1、G(n)G(n): 长度为 nn 的序列能构成的不同二叉搜索树的个数。
 * 2、F(i, n)F(i,n): 以 ii 为根、序列长度为 nn 的不同二叉搜索树个数(1≤i≤n)。
 * G(n) = ∑F(i, n)
 * F(i, n) = G(i - 1) * G(n - i)
 * 则G(n) = ∑G(i - 1) * G(n - i)
 * G(0) = 1
 * G(1) = 1
 */
class Solution96_1 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
