package jzoffer;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/13 13:33
 */
public class Offer50 {
}

class Solution50_1 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}

class Solution50_2 {
    public char firstUniqChar(String s) {
        int[] counts = new int[26];
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            counts[c - 'a']++;
        }
        for (char c : charArr) {
            if (counts[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}

class Solution50_3 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 1) {
                queue.offer(ch);
            }
            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.poll();
            }
        }
        return queue.isEmpty() ? ' ' : queue.peek();
    }
}
