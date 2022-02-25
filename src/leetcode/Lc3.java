package leetcode;

import java.util.LinkedList;

/**
 * 力扣第3题
 * 无重复字符的最长子串
 * 思想：滑动窗口
 */
class Lc3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        LinkedList queue = new LinkedList<>();
        queue.offer(s.charAt(0));
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.offer(s.charAt(i));
            if (queue.size() > max) {
                max = queue.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = new String("a");
        System.out.println(lengthOfLongestSubstring(s));
    }
}
