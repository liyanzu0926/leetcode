package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/25 13:52
 */
public class Offer65 {
}

class Solution65_1 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}

class Solution65_2 {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }
}
