package jzoffer;

/**
 * @Description
 * @Author lyz
 * @Date 2022/8/25 11:04
 */
public class Offer64 {
}

class Solution64_1 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
