package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/17 10:15
 */
public class Offer56_1 {
}

class Solution56_1_1 {
    public int[] singleNumbers(int[] nums) {
        int aXORb = 0;
        for (int i = 0; i < nums.length; i++) {
            aXORb ^= nums[i];
        }
        int diff = aXORb & (-aXORb); // 求最低位1
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};
    }
}
