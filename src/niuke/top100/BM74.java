package niuke.top100;

import java.util.*;


public class BM74 {
    /**
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    for (int l = 1; l <= 3; l++) {
                        if (i + j + k + l != s.length()) {
                            continue;
                        }
                        String s1 = s.substring(0, i);
                        String s2 = s.substring(i, i + j);
                        String s3 = s.substring(i + j, i + j + k);
                        String s4 = s.substring(i + j + k, i + j + k + l);
                        if (vaild(s1) && vaild(s2) && vaild(s3) && vaild(s4)) {
                            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean vaild(String s) {
        if (s.length() > 1 && s.charAt(0) == '0' || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}