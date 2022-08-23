package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/23 13:59
 */
public class Offer62 {
}

class Solution62_1 {
    public int lastRemaining(int n, int m) {
        int x = 0; // n = 1时，解为0
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
