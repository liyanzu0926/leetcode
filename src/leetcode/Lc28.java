package leetcode;

/**
 * @Description
 * @Author lyz
 * @Date 2022/11/8 11:16
 */
public class Lc28 {
}

class Solution28_1 {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            boolean flag = true;
            for (int j = i; j < i + len2; j++) {
                if (haystack.charAt(j) != needle.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}

class Solution28_2 {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int k = i;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = ++k;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return k;
        } else {
            return -1;
        }
    }
}
