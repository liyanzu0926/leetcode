package jzoffer;

import java.util.*;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/18 9:53
 */
public class Offer58_1 {
}

class Solution58_1_1 {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}

class Solution58_1_2 {
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        StringBuffer sb = new StringBuffer();
        Deque<String> queue = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            char ch = s.charAt(i);
            if (sb.length() != 0 && ch == ' ') {
                queue.offerFirst(sb.toString());
                sb.setLength(0);
            } else if (ch != ' ') {
                sb.append(ch);
            }
        }
        queue.offerFirst(sb.toString());
        return String.join(" ", queue);
    }
}
