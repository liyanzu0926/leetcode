package niuke.top100;

import java.util.*;


public class BM44 {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                switch (ch) {
                    case ')':
                        if (top != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (top != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (top != '{') {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
