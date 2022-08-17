package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/17 11:00
 */
public class Offer56_2 {
}

class Solution56_2_1 {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                counts[j] += nums[i] & 1;
                nums[i] >>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1; // 这行要放在下一行的前面，不然最后会多移一位
            res |= counts[i] % 3;
        }
        return res;
    }
}
