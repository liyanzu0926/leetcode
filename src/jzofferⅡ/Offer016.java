package jzofferⅡ;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/13 10:02
 */
public class Offer016 {
}

class Solution016_1 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            res = Math.max(res, j - i);
            set.remove(s.charAt(i));
        }
        return res;
    }
}

class Solution016_2 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // 移动左指针直到窗口中没有重复元素
            while (left < right && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // 移动右指针直到遇到重复元素
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
