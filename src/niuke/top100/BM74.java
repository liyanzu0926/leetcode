package niuke.top100;

import java.util.*;


class BM74_1 {

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


class BM74_2 {

    ArrayList<String> res = new ArrayList<>(); // 存放结果集
    ArrayList<String> ipset = new ArrayList<>(); // 存放每一种合法的ip子集

    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        int len = s.length();
        if (len < 4 || len > 12) { // ip最短为0.0.0.0，最长为255.255.255.255
            return res;
        }
        recall(s, 0, len);
        return res;
    }

    private void recall(String s, int index, int len) {
        if (index == len && ipset.size() == 4) {
            String ip = String.join(".", ipset);
            res.add(ip);
            return;
        }
        if (index == len || ipset.size() == 4) {
            return;
        }
        int n = Math.min(index + 3, len); // 这里比较关键，保证ip地址每一段不能超过3
        for (int i = index; i < n; i++) {
            String sub = s.substring(index, i + 1);
            // 剪枝，大于255或首位为0不合法
            if (Integer.parseInt(sub) > 255 || sub.length() > 1 && sub.charAt(0) == '0') {
                continue;
            }
            ipset.add(sub);
            recall(s, i + 1, len);
            ipset.remove(ipset.size() - 1);
        }
    }
}