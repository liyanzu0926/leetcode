package daily;

import java.util.Arrays;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/14 14:05
 */
public class Lc940 {
}

/**
 * 当字符串每个字母都不相同时，任何一个子序列再加上一个字母都会得到一个新的子序列，
 * 所以我们在求当前字母结尾的子序列个数时，就等于前面每个字母结尾的子序列的个数之和再加1，
 * 即dp[i] = dp[0] + dp[1] + dp[2] +...+ dp[i - 1] + 1，这里的+1是指子序列只包含当前字母本身。
 * 但字符串中会有相同字母，比如s = "abac", 在下标0和下标2位置都是以a结尾，
 * dp[0]包含"a"这一种情况，dp[2]包含"a", "aa", "ba", "aba"这四种情况，
 * 事实上dp[2]已经包含了dp[0]这种情况（dp[2] = dp[0] + dp[1] + 1），
 * 所以我们只要累计某个字母最后一次出现的位置上的dp值，即dp[3] = dp[1] + dp[2] + 1
 */

class Solution940_1 {
    public int distinctSubseqII(String s) {
        final long MOD = 1000000007;
        int len = s.length();
        int[] last = new int[26]; //记录某个字母最后一次出现的下标
        Arrays.fill(last, -1);
        long[] dp = new long[len];
        for (int i = 0; i < len; i++) {
            long sum = 1; // 这里的1是指当子序列只包含当前字母本身时
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    sum = (sum + dp[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i; // 更新为最后出现时的下标
            dp[i] = sum;
        }
        long res = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) {
                res = (res + dp[last[i]]) % MOD;
            }
        }
        return (int) res;
    }
}
