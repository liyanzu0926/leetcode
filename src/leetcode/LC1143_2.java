package leetcode;

public class LC1143_2 {
    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        System.out.println(longestCommonSubsequence(str1, str2));
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int pre = dp[0];
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], pre);
                }
                pre = dp[j];
            }
        }
        return dp[n];
    }
}
