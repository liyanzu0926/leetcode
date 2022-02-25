package leetcode;

public class Lc10_2 {
    /**
     * 10. 正则表达式匹配
     * 输入：s = "mississippi" p = "mis*is*p*."
     * 输出：false
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1]; //dp[i][j]表示字符串s长度为i，p的长度为j；m和n加1是因为多存了s和p长度为0的情况
        dp[0][0] = true; //s和p长度为0时匹配
        for (int j = 2; j <= n; j++) {  //初始化dp，考虑到有a*b*c*d*....这种情况，即将所有x*匹配0次时置为true
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        for (int i = 0; i < m; i++) {   //注意这里的i,j表示下标，i + 1,j + 1才表示长度
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '*') {
                    //当p[j] = * 时，有两种情况，有一种为tru即可视为当前长度匹配，1.x*匹配0次时：如果x*匹配0次（即将x*直接删除），
                    // 时为true则当前长度匹配，2.x*匹配多次时：如果p *前面的字符和s当前字符相等，且p当前长度和s长度减一时长度匹配，即可视为当前长度匹配
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || ((s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i][j + 1]);
                } else {
                    //当s当前字符和p当前字符相等，且s和p长度各减一时的状态也是匹配的，则认为当前状态也匹配
                    dp[i + 1][j + 1] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dp[i][j];
                }
            }
        }
        return dp[m][n]; //返回s和p匹配到末尾时的结果
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));

    }
}
