package daily;

import java.util.Deque;
import java.util.LinkedList;

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

class Solution856_2 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int A = stack.pop();
                int top = stack.pop() + Math.max(2 * A, 1);
                stack.push(top);
            }
        }
        return stack.peek();
    }
}

class Solution856_3 {
    public int scoreOfParentheses(String s) {
        int res = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += s.charAt(i) == '(' ? 1 : -1;
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                res += 1 << balance;
            }
        }
        return res;
    }
}
