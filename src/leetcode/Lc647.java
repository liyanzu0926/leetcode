package leetcode;

import java.util.LinkedList;

public class Lc647 {
}

/**
 * 枚举所有可能的回文串
 */
class Solution647_1 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (isSubstrings(s.substring(j, i + 1))){
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isSubstrings(String substring) {
        for (int i = 0; i < substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}

/**
 * 枚举所有的中心
 */
class Solution647_2 {
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 回文串长度为奇数 + 回文串长度为偶数
            res += count(s, i, i) + count(s, i, i + 1);
        }
        return res;
    }

    private int count(String s, int left, int right) {
        int sum = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            sum++;
        }
        return sum;
    }
}
