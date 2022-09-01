package jzofferⅡ;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author lyz
 * @Date 2022/9/1 10:16
 */
public class Offer004 {
}

class Solution004_1 {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                counts[j] += (nums[i] & 1);
                nums[i] >>= 1;
            }
        }
        int res = 0;
        int m = 3;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= counts[i] % m;
        }
        return res;
    }
}

class Solution004_2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
