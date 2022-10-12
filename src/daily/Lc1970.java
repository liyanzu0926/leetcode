package daily;

/**
 * @Description
 * @Author lyz
 * @Date 2022/10/12 10:21
 */
public class Lc1970 {
}

class Solution1970_1 {
    public boolean areAlmostEqual(String s1, String s2) {
        int diff = 0;
        int ch1 = 0;
        int ch2 = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if ((diff == 2 && (ch1 != s2.charAt(i) || ch2 != s1.charAt(i))) || diff > 2) {
                    return false;
                }
                ch1 = s1.charAt(i);
                ch2 = s2.charAt(i);
            }
        }
        if (diff == 0 || diff == 2) {
            return true;
        }
        return false;
    }
}
