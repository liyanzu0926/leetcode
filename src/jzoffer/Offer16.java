package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/13 10:16
 */
public class Offer16 {
}

/**
 * @Description: 递归
 * @author: lww
 * @date: 2022/7/13 11:03
 */
class Solution16_1 {
    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}

/**
 * @Description: 迭代
 * @author: lww
 * @date: 2022/7/13 11:04
 */
class Solution16_2 {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double res = 1;
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1.0 / x;
        }
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return res;
    }
}
