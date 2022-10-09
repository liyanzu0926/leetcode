package daily;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/9 13:39
 */
public class Lc856 {
}

class Solution856_1 {
    public int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }
        int balance = 0;
        int n = s.length();
        int len = 0;
        for (int i = 0; i < n; i++) {
            balance += s.charAt(i) == '(' ? 1 : -1;
            if (balance == 0) {
                len = i + 1;
                break;
            }
        }
        if (len == n) {
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
        }
    }
}
