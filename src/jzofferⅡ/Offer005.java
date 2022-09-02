package jzofferⅡ;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/2 11:24
 */
public class Offer005 {
}

class Solution005_1 {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                mask[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}

class Solution005_2 {
    public int maxProduct(String[] words) {
        int len = words.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask |= 1 << (word.charAt(j) - 'a');
            }
            map.put(mask, Math.max(map.getOrDefault(mask, 0), words[i].length()));
        }
        int res = 0;
        for (int key1 : map.keySet()) {
            for (int key2 : map.keySet()) {
                if ((key1 & key2) == 0) {
                    res = Math.max(res, map.get(key1) * map.get(key2));
                }
            }
        }
        return res;
    }
}
