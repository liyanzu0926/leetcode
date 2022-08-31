package jzofferⅡ;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/31 11:10
 */
public class OfferⅡ001 {
}

class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            int base = b;
            int k = 1;
            // 把 a <= base + base 改成 a - base <= base ，因为 base + base 可能会溢出
            while (a - base <= base) {
                base += base;
                k += k;
            }
            a -= base;
            res += k;
        }
        return sign == 1 ? res : -res;
    }
}
