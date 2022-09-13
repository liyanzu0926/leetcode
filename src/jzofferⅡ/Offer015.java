package jzofferⅡ;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/13 9:47
 */
public class Offer015 {
}

class Solution015_1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int len1 = s.length();
        int len2 = p.length();
        if (len1 < len2) {
            return res;
        }
        int[] count = new int[26];
        for (int i = 0; i < len2; i++) {
            count[p.charAt(i) - 'a']--;
        }
        int left = 0;
        int right = 0;
        while (right < len1) {
            int x = s.charAt(right) - 'a';
            count[x]++;
            while (count[x] > 0) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == len2) {
                res.add(left);
            }
            right++;
        }
        return res;
    }
}
