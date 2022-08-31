package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/31 11:31
 */
public class Offer002 {
}

class Solution002_1 {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        while (len1 > 0 || len2 > 0 || carry != 0) {
            int sum = carry;
            if (len1 > 0) {
                sum += a.charAt(len1 - 1) - '0';
                len1--;
            }
            if (len2 > 0) {
                sum += b.charAt(len2 - 1) - '0';
                len2--;
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        sb.reverse();
        return sb.toString();
    }
}
