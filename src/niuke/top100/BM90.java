package niuke.top100;

import java.util.*;

class BM90 {

    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cur = new HashMap<>();

    public String minWindow(String S, String T) {
        // write code here
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();
        int sLen = S.length();
        int tLen = T.length();
        for (int i = 0; i < tLen; i++) {
            char ch = tArr[i];
            ori.put(ch, ori.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minLength = sLen + 1;
        while (right < sLen) {
            while (right < sLen && ori.get(sArr[right]) == null) {
                cur.put(sArr[right], cur.getOrDefault(sArr[right], 0) + 1);
                right++;
            }
            if (right >= sLen) {
                break;
            }
            cur.put(sArr[right], cur.getOrDefault(sArr[right], 0) + 1);
            while (left < right && ori.get(sArr[left]) == null) {
                cur.put(sArr[left], cur.getOrDefault(sArr[left], 0) - 1);
                left++;
            }
            while (check()) {
                int curLength = right - left + 1;
                if (curLength < minLength) {
                    minLeft = left;
                    minLength = curLength;
                }
                cur.put(sArr[left], cur.getOrDefault(sArr[left], 0) - 1);
                left++;
                while (left < right && ori.get(sArr[left]) == null) {
                    cur.put(sArr[left], cur.getOrDefault(sArr[left], 0) - 1);
                    left++;
                }
            }
            right++;
        }
        if (minLength == sLen + 1) {
            return "";
        }
        return S.substring(minLeft, minLeft + minLength);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            if (cur.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
