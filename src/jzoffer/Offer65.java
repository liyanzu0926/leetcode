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
            int carry = a & b; // 进位
            a = a ^ b; // 本位
            b = carry << 1; // 进位整体左移，交错相加
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
