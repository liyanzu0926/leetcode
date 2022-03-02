package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Lc76 {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(new Solution76_2().minWindow(s, t));
    }
}

/**
 * 滑动窗口
 * 用hashmap存储该字符出现的次数
 * cur这个map记录当前窗口中所有字符及其出现次数
 * 当t字符串中的所有字符都出现在了窗口里，就缩小窗口，找到能包含t字符串的最小窗口，
 * 当窗口不再包含t所有字符串时，则继续扩大窗口
 */
class Solution76_1 {
    Map<Character, Integer> ori = new HashMap<>(); // 记录t字符串中所有字符出现的次数
    Map<Character, Integer> cur = new HashMap<>();// 记录当前窗口所有字符出现的次数

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char ch = t.charAt(i);
            ori.put(ch, ori.getOrDefault(ch, 0) + 1);
        }
        int r = 0; // 窗口右边界
        int l = 0; // 窗口左边界
        int minl = -1; // 最小窗口左边界
        int minr = -1; // 最小窗口右边界
        int minLen = sLen + 1; // 最小窗口宽度

        while (r < sLen) {
            char ch1 = s.charAt(r);
            cur.put(ch1, cur.getOrDefault(ch1, 0) + 1);
            while (check() && l <= r) {
                int localLen = r - l + 1;
                if (localLen < minLen) {
                    minl = l;
                    minr = r;
                    minLen = localLen;
                }
                char ch2 = s.charAt(l);
                cur.put(ch2, cur.getOrDefault(ch2, 0) - 1);
                l++;
            }
            r++;
        }
        if (minLen >= sLen + 1) {
            return "";
        }
        return s.substring(minl, minr + 1);
    }

    // 检查当前窗口是否包含t字符串所有字符
    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (cur.getOrDefault(next.getKey(), 0) < next.getValue()) {
                return false;
            }
        }
        return true;
    }
}

class Solution76_2 {
    Map<Character, Integer> ori = new HashMap<>(); // 记录t字符串中所有字符出现的次数
    Map<Character, Integer> cur = new HashMap<>();// 记录当前窗口所有字符出现的次数

    public String minWindow(String s, String t) {
        int sLen = s.length();
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        for (char c : charsT) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int r = 0; // 窗口右边界
        int l = 0; // 窗口左边界
        int minl = -1; // 最小窗口左边界
        int minr = -1; // 最小窗口右边界
        int minLen = sLen + 1; // 最小窗口宽度

        while (r < sLen) {
            while (r < sLen && ori.get(charsS[r]) == null) {
                cur.put(charsS[r], cur.getOrDefault(charsS[r], 0) + 1);
                r++;
            }
            if (r >= sLen) break;
            cur.put(charsS[r], cur.getOrDefault(charsS[r], 0) + 1);
            while (ori.get(charsS[l]) == null && l <= r) {
                cur.put(charsS[l], cur.getOrDefault(charsS[l], 0) - 1);
                l++;
            }
            while (check()) {
                int localLen = r - l + 1;
                if (localLen < minLen) {
                    minl = l;
                    minr = r;
                    minLen = localLen;
                }
                cur.put(charsS[l], cur.getOrDefault(charsS[l], 0) - 1);
                l++;
                while (l <= r && ori.get(charsS[l]) == null) {
                    cur.put(charsS[l], cur.getOrDefault(charsS[l], 0) - 1);
                    l++;
                }
            }
            r++;
        }
        if (minLen >= sLen + 1) {
            return "";
        }
        return s.substring(minl, minr + 1);
    }

    // 检查当前窗口是否包含t字符串所有字符
    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (cur.getOrDefault(next.getKey(), 0) < next.getValue()) {
                return false;
            }
        }
        return true;
    }
}
