package niuke.top100;

import java.util.*;


public class BM86 {

    public String solve(String s, String t) {
        // write code here
        int i = s.length() - 1;
        int j = t.length() - 1;
        int curr = 0;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 && j >= 0) {
            int a = s.charAt(i) - '0';
            int b = t.charAt(j) - '0';
            curr = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            sb.insert(0, curr);
            i--;
            j--;
        }
        while (i >= 0) {
            int a = s.charAt(i) - '0';
            curr = (a + carry) % 10;
            carry = (a + carry) / 10;
            sb.insert(0, curr);
            i--;
        }
        while (j >= 0) {
            int b = t.charAt(j) - '0';
            curr = (b + carry) % 10;
            carry = (b + carry) / 10;
            sb.insert(0, curr);
            j--;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
