package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/16 10:29
 */
public class Offer020 {
}

class Solution020_1 {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                res++;
            }
        }
        return res;
    }
}
