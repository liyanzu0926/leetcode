package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/6/1 12:19
 */
public class Offer10_1 {
}

class Solution10_1_1 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int n0 = 0;
        int n1 = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (n0 + n1) % 1000000007;
            n0 = n1;
            n1 = ans;
        }
        return ans;
    }
}
