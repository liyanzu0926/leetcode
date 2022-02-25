package leetcode;

/**
 * 14. 最长公共前缀
 * 思想：分治法
 * 0  1  2  3  4  5
 * m
 * m
 * m
 * l  r
 * l    r
 * l
 * m
 * l  r
 * l     r
 * r
 * m
 * <p>
 * 可以在纸上画一画
 */

public class Lc14_2 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs[0].length() == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public static String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = (start + end) / 2;
        String leftStr = longestCommonPrefix(strs, start, mid);
        String rightStr = longestCommonPrefix(strs, mid + 1, end);
        return commonPrefix(leftStr, rightStr);
    }

    private static String commonPrefix(String leftStr, String rightStr) {
        int len = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < len; i++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)) {
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0, len);
    }

    public static void main(String[] args) {
        String strs[] = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
