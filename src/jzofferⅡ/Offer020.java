package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/16 10:29
 */
public class Offer020 {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(new Solution020_2().countSubstrings(str));
    }
}

class Solution020_1 {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                res++;
            }
        }
        return res;
    }
}

class Solution020_2 {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // s.charAt(i) == s.charAt(j)时，
                // 1). i == j表示同一个字符，肯定是回文串
                // 2). i + 1 == j表示aa这种情况，也是回文串
                // 3). dp[i + 1][j - 1] == true表示它们的子串s[i+1...j-1]是回文串，那么s[i..j]也是回文串
                if (s.charAt(i) == s.charAt(j) && (i == j || i + 1 == j || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
