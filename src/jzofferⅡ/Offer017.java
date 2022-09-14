package jzofferⅡ;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/14 10:07
 */
public class Offer017 {
}

class Solution017_1 {
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cur = new HashMap<>();

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        for (int i = 0; i < tLen; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (right < sLen) {
            if (ori.containsKey(s.charAt(right))) {
                cur.put(s.charAt(right), cur.getOrDefault(s.charAt(right), 0) + 1);
            }
            right++;
            while (left < right && check()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }
                if (cur.containsKey(s.charAt(left))) {
                    cur.put(s.charAt(left), cur.get(s.charAt(left)) - 1);
                }
                left++;
            }
        }
        return s.substring(start, end);
    }

    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> next = iter.next();
            Character key = next.getKey();
            Integer val = next.getValue();
            if (cur.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}

class Solution017_2 {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        int[] hash = new int[58]; // A-Z的ascii码为65-90 ，a-z的ascii码为97-122
        for (int i = 0; i < tLen; i++) {
            hash[t.charAt(i) - 'A']++;
            hash[s.charAt(i) - 'A']--; // s中字符移进窗口是--，移出窗口是++
        }
        // 此时窗口中未被抵消的字符的hash值是>0的，比如t = "ABC"，s = "A*B*C*"
        // s中参杂着一些t中没有的字符*，它们的hash值是小于0的，我们不用关心
        int diff = 0;
        for (int i = 0; i < 58; i++) {
            if (hash[i] > 0) { // 只关心hash值大于0的，即只关心未抵消的字符
                diff++;
            }
        }
        // 最小窗口
        if (diff == 0) {
            return s.substring(0, tLen);
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int left = 0;
        for (int right = tLen; right < sLen; right++) {
            int x = s.charAt(right) - 'A';
            hash[x]--;
            if (hash[x] == 0) {
                diff--;
            }
            // 移动右指针直到窗口覆盖t中所有字符
            if (diff != 0) {
                continue;
            }
            // 此时窗口已覆盖t中所有字符(diff=0)，开始收缩窗口（移动左指针）
            while (diff == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                    end = right;
                }
                int y = s.charAt(left) - 'A';
                hash[y]++;
                if (hash[y] == 1) { // hash[y]从0变到1的，说明s包含t的某个字符被移出窗口了
                    diff++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end + 1); // substring是左闭右开的
    }
}
