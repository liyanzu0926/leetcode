package leetcode;

public class Lc5_2 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        boolean[][] db = new boolean[s.length()][s.length()];
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 0;
        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left + 1 <= 3 || db[left + 1][right - 1])) {
                    db[left][right] = true;
                    if (right - left + 1 > maxLen) {
                        maxStart = left;
                        maxEnd = right;
                        maxLen = right - left + 1;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
