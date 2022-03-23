package niuke.alibaba;

/**
 * 求结点数为n，高度不超过m，有多少种二叉树（类似leetcode第96）
 * https://www.nowcoder.com/questionTerminal/aaefe5896cce4204b276e213e725f3ea
 */

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        long[][] dp = new long[n + 1][m + 1];
        // 为什么要把0个结点这一行初始化为0？因为结点数为n的树的高度只要不超过m，有多少种算多少种
        // 而0个结点也算一种情况
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int h = 1; h <= m; h++) {  // 注意高度的循环一定要在结点循环的里面，这样才能控制高度不超过m
                for (int j = 1; j <= i; j++) {
                    dp[i][h] = (dp[i][h] + dp[j - 1][h - 1] * dp[i - j][h - 1] % mod) % mod;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}

