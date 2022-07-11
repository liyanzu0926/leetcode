package jzoffer;

/**
 * @Description
 * @Author lww
 * @Date 2022/7/11 10:22
 */
public class Offer14_2 {
}

class Solution14_2_1 {
    public int cuttingRope(int n) {
        if (n < 4){
            return n - 1;
        }
        long res = 1;
        while (n > 4){
            res = res * 3 % 1000000007;
            n -= 3;
        }
        res = res * n % 1000000007;
        return (int)res;
    }
}
