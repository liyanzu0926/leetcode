package leetcode;

public class Lc231 {
}

class Solution231_1 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n != 0) {
            if (n != 1 && n % 2 == 1) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}

class Solution231_2 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0 ? true : false;
    }
}
