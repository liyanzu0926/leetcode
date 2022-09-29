package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/29 11:03
 */
public class Offer034 {
}

class Solution034_1 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        // 两两比较
        for (int i = 1; i < words.length; i++) {
            if (!check(words[i - 1], words[i], index)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(String str1, String str2, int[] index) {
        int len1 = str1.length();
        int len2 = str2.length();
        int i = 0;
        while (i < len1 && i < len2) {
            int order1 = index[str1.charAt(i) - 'a'];
            int order2 = index[str2.charAt(i) - 'a'];
            if (order1 > order2) {
                return false;
            } else if (order1 < order2) {
                return true;
            } else {
                i++;
            }
        }
        // 此时为"apple","app"这种情况
        if (i < len1) {
            return false;
        }
        return true;
    }
}
