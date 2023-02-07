package leetcode;

/**
 * @Description
 * @Author lyz
 * @Date 2023/2/7 9:48
 */
public class Lc10_3 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        if (m == 0 && n == 0) {
            return true;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 如果s(i)和p(j - 1)匹配，1.当*匹配多次，可以把s的第i个字符丢掉继续往后比；
                    // 2.当*匹配1次，此时相当于s(i)和p(j - 1)比较，能不能匹配取决于s(i)和p(j - 2)能不能匹配；
                    if (match(s, i, p, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        // 如果s(i)和p(j - 1)不匹配，则抛弃a*组合，即*匹配前面字母0次
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (match(s, i, p, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    private static boolean match(String s, int i, String p, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
