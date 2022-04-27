package niuke.top100;

import java.util.*;

public class BM83 {
    public String trans(String s, int n) {
        // write code here
        String[] arr = s.split(" ", -1);
        StringBuffer sb = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(transform(arr[i]) + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String transform(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
}
