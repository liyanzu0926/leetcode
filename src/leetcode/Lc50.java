package leetcode;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/30 9:58
 */
public class Lc50 {
}

class Solution50_1 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}

class Solution50_2 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        double ans = 1;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
            }
            x *= x;
            N /= 2;
        }
        return ans;
    }
}
