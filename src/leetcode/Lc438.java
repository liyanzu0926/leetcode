package leetcode;

import java.util.*;

public class Lc438 {
}

/**
 * 滑动窗口
 */
class Solution438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                res.add(i);
            }
        }
        return res;
    }
}

/**
 * 滑动窗口
 * 当high扫描到的字符是p中的字符，则继续扫描。
 * 当high扫描到的字符不是p中的字符，则原地等待，让low指针向前移，直到把这个不是p中的字符移除窗口为止
 */
class Solution438_2 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen) {
            return new ArrayList<>();
        }
        int[] count = new int[26];
        for (int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']++;
        }
        int low = 0;
        int high = 0;
        List<Integer> res = new ArrayList<>();
        while (high < sLen){
            if (count[s.charAt(high) - 'a'] > 0){
                count[s.charAt(high++) - 'a']--;
                if (high - low == pLen){
                    res.add(low);
                }
            }else {
                count[s.charAt(low++) - 'a']++;
            }
        }
        return res;
    }
}
