package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/29 11:31
 */
public class Offer67 {
}

class Solution67_1 {
    public int strToInt(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        long res = 0;
        int sign = 1;
        int start = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else if (str.charAt(0) == '+') {
            start = 1;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
            } else {
                res = res * 10 + str.charAt(i) - '0';
            }
            if (res > Integer.MAX_VALUE) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return (int) (sign * res);
    }
}
