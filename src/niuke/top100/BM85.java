package niuke.top100;

import java.util.*;


public class BM85 {

    public String solve(String IP) {
        // write code here
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isIPv4(String IP) {
        String[] strs = IP.split("\\.");
        int len = strs.length;
        if (len == 0 || len != 4) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            // 首位不能为零或长度不能大于3
            if (strs[i].charAt(0) == '0' || strs[i].length() == 0 || strs[i].length() > 3) {
                return false;
            }
            // 不能有字母
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) < '0' || strs[i].charAt(j) > '9') {
                    return false;
                }
            }
            // ipv4每段应在0-255范围
            if (Integer.parseInt(strs[i]) < 0 || Integer.parseInt(strs[i]) > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String IP) {
        String[] strs = IP.split(":", -1);
        int len = strs.length;
        if (len == 0 || len != 8) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            // 每段长度不能为0或大于4
            if (strs[i].length() == 0 || strs[i].length() > 4) {
                return false;
            }
            // 前两位不能都为0
            if (strs[i].length() >= 2 && strs[i].charAt(0) == '0' && strs[i].charAt(1) == '0') {
                return false;
            }
            // 判断字母是否在a-f或A-F之间
            for (int j = 0; j < strs[i].length(); j++) {
                char ch = strs[i].charAt(j);
                if (!Character.isDigit(ch) && (ch < 'a' || ch > 'f') && (ch < 'A' || ch > 'F')) {
                    return false;
                }
            }
        }
        return true;
    }
}
