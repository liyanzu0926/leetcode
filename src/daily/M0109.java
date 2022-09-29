package daily;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/29 9:39
 */
public class M0109 {
}

class Solution0109_1 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (s1.charAt((i + j) % len) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}

class Solution0109_2 {
    public boolean isFlipedString(String s1, String s2) {
        String s = s1 + s1;
        return s1.length() == s2.length() && s.contains(s2);
    }
}
