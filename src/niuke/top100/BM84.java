package niuke.top100;

import java.util.*;


public class BM84 {

    public String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs.length == 0 || strs == null) {
            return "";
        }
        int len = strs.length;
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
