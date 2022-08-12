package jzoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/12 10:58
 */
public class Offer48 {
}

class Solution48_1 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!list.contains(s.charAt(j))) {
                    list.add(s.charAt(j));
                } else {
                    max = Math.max(max, list.size());
                    list.clear();
                    break;
                }
            }
        }
        return max;
    }
}

class Solution48_2 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int left = 0;
        int right = 0;
        int max = 1;
        Set<Character> set = new HashSet<>();
        while (right < len) {
            // 移动左指针直到窗口中没有重复字符
            while (left < right && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // 移动右指针直到遇到重复字符
            while (right < len && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}


