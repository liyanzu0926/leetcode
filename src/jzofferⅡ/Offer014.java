package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/9 10:53
 */
public class Offer014 {
}

class Solution014_1 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']--;
            count[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            int left_char = s2.charAt(i - len1) - 'a';
            int right_char = s2.charAt(i) - 'a';
            if (left_char == right_char) {
                continue;
            }
            if (count[right_char] == 0) {
                diff++;
            }
            count[right_char]++;
            if (count[right_char] == 0) {
                diff--;
            }
            if (count[left_char] == 0) {
                diff++;
            }
            count[left_char]--;
            if (count[left_char] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}

class Solution014_2 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        int right = 0;
        while (right < len2) {
            int x = s2.charAt(right) - 'a';
            count[x]++;
            // count中有大于0的就把它消掉
            while (count[x] > 0) {
                count[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == len1) {
                return true;
            }
            right++;
        }
        return false;
    }
}
