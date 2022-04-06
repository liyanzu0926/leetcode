package niuke.top100;

import java.util.*;


public class BM65 {

    public String LCS(String s1, String s2) {
        // write code here
        int len1 = s1.length();
        int len2 = s2.length();
        // dp[i][j]记录s1长度为i，s2长度为j的最长公共子序列长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 此时最长公共子序列的长度为dp[len1][len2]
        // 倒推LCS ，即从i = len1，j = len2开始往后推
        // 当s1.charAt(i - 1) == s2.charAt(j - 1)时，将该字符并入LCS串
        // 当s1.charAt(i - 1) != s2.charAt(j - 1)时，
        // 判断dp[i][j]这个状态是由dp[i - 1][j]转移过来的，
        // 还是由dp[i][j - 1]转移过来的。
        // 所以我们判断dp[i - 1][j]和dp[i][j - 1]的大小，
        // 当dp[i - 1][j] > dp[i][j - 1]时，说明是从dp[i - 1][j]转移过来的，
        // 则我们回退回去，令 i--，反之j--，重复这个操作到结束。
        int i = len1;
        int j = len2;
        StringBuffer sb = new StringBuffer();
        while (i != 0 && j != 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return sb.length() == 0 ? "-1" : sb.toString();
    }
}
