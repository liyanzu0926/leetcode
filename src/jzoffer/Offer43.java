package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/9 11:08
 */
public class Offer43 {
}

class Solution43_1 {
    public int countDigitOne(int n) {
        long muk = 1;
        int res = 0;
        while (n >= muk) {
            res += (n / (muk * 10) * muk + Math.min(Math.max(n % (muk * 10) - muk + 1, 0), muk));
            muk *= 10;
        }
        return res;
    }
}
