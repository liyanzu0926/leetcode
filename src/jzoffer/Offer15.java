package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/12 10:09
 */
public class Offer15 {
}

class Solution15_1 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}

class Solution15_2 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }
}
