package leetcode;

public class Lc10_1 {
    /**
     * 10. 正则表达式匹配
     * 输入：s = "mississippi" p = "mis*is*p*."
     * 输出：false
     */

    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || (p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s, p));

    }
}
