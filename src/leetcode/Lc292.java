package leetcode;

public class Lc292 {
}

class Solution292 {
    public boolean canWinNim(int n) {
        // a % x = a & (x - 1)
        return (n & 3) > 0;
    }
}
